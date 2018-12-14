package com.jd.cms.test.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaochengye
 * @date 2018/12/13 11:34
 */
public class HDFSUtils {
//    public static FileSystem fs = null;
//    public static Configuration conf = null;
    // Hadoop的用户名
//    public static String hdfsUserName = "hadoop";
//    public static URI hdfsUri = null;

//    static {
//        conf = new Configuration();
//
//        try{
//            // HDFS的访问路径
//            hdfsUri = new URI("hdfs://hadoopcm0:8020/");
////            fs = FileSystem.get(conf);
//            fs = FileSystem.get(hdfsUri,conf,hdfsUserName);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }




    /**
     * 根据配置文件获取HDFS操作对象
     * 有两种方法：
     *  1.使用conf直接从本地获取配置文件创建HDFS对象
     *  2.多用于本地没有hadoop系统，但是可以远程访问。使用给定的URI和用户名，访问远程的配置文件，然后创建HDFS对象。
     * @return FileSystem
     */
    public FileSystem getHadoopFileSystem() {


        FileSystem fs = null;
        Configuration conf = null;

        // 方法一，本地有配置文件，直接获取配置文件（core-site.xml，hdfs-site.xml）
        // 根据配置文件创建HDFS对象
        // 此时必须指定hdsf的访问路径。
//        conf = new Configuration();
        // 文件系统为必须设置的内容。其他配置参数可以自行设置，且优先级最高
//        conf.set("fs.defaultFS", "hdfs://huabingood01:9000");

//        try {
//            // 根据配置文件创建HDFS对象
//            fs = FileSystem.get(conf);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 方法二：本地没有hadoop系统，但是可以远程访问。根据给定的URI和用户名，访问hdfs的配置参数
        // 此时的conf不需任何设置，只需读取远程的配置文件即可。
                    conf = new Configuration();
                    // Hadoop的用户名
                    String hdfsUserName = "hadoop";

                    URI hdfsUri = null;
                    try {
                        // HDFS的访问路径
                        hdfsUri = new URI("hdfs://hadoopcm0:8020/");
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }

                    try {
                        // 根据远程的NN节点，获取配置信息，创建HDFS对象
                        fs = FileSystem.get(hdfsUri,conf,hdfsUserName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

        // 方法三，反正我们没有搞懂。
                    /*conf  = new Configuration();
                    conf.addResource("/opt/huabingood/pseudoDistributeHadoop/hadoop-2.6.0-cdh5.10.0/etc/hadoop/core-site.xml");
                    conf.addResource("/opt/huabingood/pseudoDistributeHadoop/hadoop-2.6.0-cdh5.10.0/etc/hadoop/hdfs-site.xml");

                    try {
                        fs = FileSystem.get(conf);
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error(e);
                    }*/

        return fs;
    }

    /**
     * 这里的创建文件夹同shell中的mkdir -p 语序前面的文件夹不存在
     * 跟java中的IO操作一样，也只能对path对象做操作；但是这里的Path对象是hdfs中的
     * @param fs
     * @return
     */
    public  boolean createPath(FileSystem fs, Path path){
        boolean b = false;

//        Path path = new Path("/user/zcyTest/temp2");
        try {
            // even the path exist,it can also create the path.
            b = fs.mkdirs(path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                fs.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return b;
    }

    /**
     * 删除文件，实际上删除的是给定path路径的最后一个
     * 跟java中一样，也需要path对象，不过是hadoop.fs包中的。
     * 实际上delete(Path p)已经过时了，更多使用delete(Path p,boolean recursive)
     * 后面的布尔值实际上是对文件的删除，相当于rm -r
     * @param fs
     * @return
     */
    public boolean dropPath(FileSystem fs, Path path){
        boolean b = false;
        // drop the last path
//        Path path = new Path("/huabingood/hadoop.tar.gz");
        try {
            b = fs.delete(path,true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                fs.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        return b;
    }


    /**
     * 重命名文件夹
     * @param hdfs
     * @return
     */
    public boolean renameDic(FileSystem hdfs, Path oldPath, Path newPath){
        boolean b = false;
//        Path oldPath = new Path("/hyw/test/huabingood");
//        Path newPath = new Path("/hyw/test/huabing");

        try {
            b = hdfs.rename(oldPath,newPath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            try {
//                hdfs.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        return b;
    }

    /**
     * 遍历文件夹
     * public FileStatus[] listStatus(Path p)
     * 通常使用HDFS文件系统的listStatus(path)来获取改定路径的子路径。然后逐个判断
     * 值得注意的是：
     *  1.并不是总有文件夹中有文件，有些文件夹是空的，如果仅仅做是否为文件的判断会有问题，必须加文件的长度是否为0的判断
     *  2.使用getPath()方法获取的是FileStatus对象是带URL路径的。使用FileStatus.getPath().toUri().getPath()获取的路径才是不带url的路径
     * @param hdfs
     * @param listPath 传入的HDFS开始遍历的路径
     * @return
     */
    public Set<String> recursiveHdfsPath(FileSystem hdfs, Path listPath){
                Set set = new HashSet();
                /*FileStatus[] files = null;
                try {
                    files = hdfs.listStatus(listPath);
                    Path[] paths = FileUtil.stat2Paths(files);
                    for(int i=0;i<files.length;i++){
                        if(files[i].isFile()){
                            // set.add(paths[i].toString());
                            set.add(paths[i].getName());
                        }else {
                            recursiveHdfsPath(hdfs,paths[i]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e);
                }*/

        FileStatus[] files = null;

        try {
            files = hdfs.listStatus(listPath);
            // 实际上并不是每个文件夹都会有文件的。
            if(files.length == 0){
                // 如果不使用toUri()，获取的路径带URL。
                set.add(listPath.toUri().getPath());
            }else {
                // 判断是否为文件
                for (FileStatus f : files) {
                    if (files.length == 0 || f.isFile()) {
                        set.add(f.getPath().toUri().getPath());
                    } else {
                        set.add(f.getPath().toUri().getPath());//文件夹也需要展示一条
                        // 是文件夹，且非空，就继续遍历
                        recursiveHdfsPath(hdfs, f.getPath());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }


    /**
     * 文件简单的判断
     * 是否存在
     * 是否是文件夹
     * 是否是文件
     * @param fs
     */
    public void checkFile(FileSystem fs, Path path) {
        boolean isExists = false;
        boolean isDirectorys = false;
        boolean isFiles = false;

//        Path path = new Path("/hyw/test/huabingood01");

        try {
            isExists = fs.exists(path);
            isDirectorys = fs.isDirectory(path);
            isFiles = fs.isFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                fs.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        if (!isExists) {
            System.out.println("path exist!");
        } else {
            System.out.println("path exist!");
            if (isDirectorys) {
                System.out.println("Directory");
            } else if (isFiles) {
                System.out.println("Files");
            }
        }
    }

    /**
     * 文件的上传
     * 注意事项同文件的上传
     * 注意如果上传的路径不存在会自动创建
     * 如果存在同名的文件，会覆盖
     * @param fs
     */
    public void uploadFile(FileSystem fs, Path localPath, Path hdfsPath){

        boolean pathExists = false;
        // 如果上传的路径不存在会创建
        // 如果该路径文件已存在，就会覆盖
//        Path localPath = new Path("/home/huabingood/绣春刀.rmbv");
//        Path hdfsPath = new Path("/hyw/test/huabingood/abc/efg/绣春刀.rmbv");

        try {
            fs.copyFromLocalFile(localPath,hdfsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            try {
//                fs.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

    }

    /**
     * 文件下载
     * 注意下载的路径的最后一个地址是下载的文件名
     * copyToLocalFile(Path local,Path hdfs)
     * 下载命令中的参数是没有任何布尔值的，如果添加了布尔是，意味着这是moveToLocalFile()
     * @param fs
     */
    public void downloadFile(FileSystem fs, Path hdfsPath, Path localPath){
//        Path hdfsPath = new Path("/hyw/test/hadoop-2.6.0-cdh5.10.0.tar.gz");
//        Path localPath = new Path("/home/huabingood");

        try {
            fs.copyToLocalFile(hdfsPath,localPath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            try {
//                fs.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    /**
     * hdfs之间文件的复制
     * 使用FSDataInputStream来打开文件open(Path p)
     * 使用FSDataOutputStream开创建写到的路径create(Path p)
     * 使用 IOUtils.copyBytes(FSDataInputStream,FSDataOutputStream,int buffer,Boolean isClose)来进行具体的读写
     * 说明：
     *  1.java中使用缓冲区来加速读取文件，这里也使用了缓冲区，但是只要指定缓冲区大小即可，不必单独设置一个新的数组来接受
     *  2.最后一个布尔值表示是否使用完后关闭读写流。通常是false，如果不手动关会报错的
     * @param hdfs
     */
    public void copyFileBetweenHDFS(FileSystem hdfs,Path srcPath, Path decPath){
//        Path srcPath = new Path("/hyw/test/hadoop-2.6.0-cdh5.10.0.tar.gz");
//        Path decPath = new Path("/huabin/hadoop.tar.gz");

        // byte[] ioBuffer = new byte[1024*1024*64];
        // int len = 0;

        FSDataInputStream hdfsIn = null;
        FSDataOutputStream hdfsOut = null;

        try {
            hdfsIn = hdfs.open(srcPath);
            hdfsOut = hdfs.create(decPath);

            IOUtils.copyBytes(hdfsIn,hdfsOut,1024*1024*64,false);

                    /*while((len=hdfsIn.read(ioBuffer))!= -1){
                        IOUtils.copyBytes(hdfsIn,hdfsOut,len,true);
                    }*/
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                hdfsOut.close();
                hdfsIn.close();//没有关闭fs
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
