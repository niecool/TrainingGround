package com.jd.cms.test.hdfs;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * @author zhaochengye
 * @date 2018/12/13 22:44
 */
public class HbaseTest {

    public static void main(String[] args) {
        HDFSUtils ut = new HDFSUtils();
        FileSystem fs = ut.getHadoopFileSystem();
        //add dictionary
        Path parentPath = new Path("/user/zcyTest");
        Path path1 = new Path("/user/zcyTest/temp");
        Path path2 = new Path("/user/zcyTest/temp2");
        Path path3 = new Path("/user/zcyTest/temp3");
        Path localFile = new Path("/Users/zhaochengye/Desktop/hdfsShell1.txt");
        Path hdfsFile = new Path("/user/zcyTest/temp/hdfsShells.txt");
        Path hdfsFile2 = new Path("/user/zcyTest/temp2/hdfsShells.txt");
//        ut.createPath(fs,path1);
        //del dictionary
//        ut.dropPath(fs,path1);
        //rename
//        ut.renameDic(fs,path2,path1);

        //show dictionaries and files
//        Set set = ut.recursiveHdfsPath(fs,parentPath);
//        Iterator it = set.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        //check File
//        ut.checkFile(fs,parentPath);

        //upload File
//        ut.uploadFile(fs,localFile,hdfsFile);
        //download
//        ut.downloadFile(fs,hdfsFile,localFile);

        //io practice
//        ut.createPath(fs,path2);
//        ut.copyFileBetweenHDFS(fs,hdfsFile,hdfsFile2);
//        ut.createPath(fs,path3);
//        Path hdfsFile3 = new Path("/user/zcyTest/input/hdfsShell.txt");
//        ut.copyFileBetweenHDFS(fs,hdfsFile,hdfsFile3);
        for (int i = 1; i < 100; i++) {
            ut.dropPath(fs, new Path("/user/zcyTest/output" + i));
        }
    }
}
