package com.jd.cms.test.controller.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;

/**
 * @author zhaochengye
 * @date 2019-04-13 10:02
 */
public class UploadServlet  extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response){
//        InputStream is = null;
//        PrintWriter os = null;
//        try {
//            request.setCharacterEncoding("UTF-8");
//            String contentType = request.getHeader("Content-type");
//            System.out.println("contentType:  "+contentType);
//
//            is = request.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String splitString = br.readLine();
//            System.out.println(splitString);
//            String fileInfo = br.readLine();
//            String fileName = fileInfo.substring(fileInfo.indexOf("; name=\"")+8,fileInfo.indexOf("\"; filename="));
//            System.out.println(fileName);
//            System.out.println(br.readLine());
//            br.readLine();
//
//            File dir = new File("/Users/zhaochengye/Documents/gitProject/gitUserHand/cms/target/cms/WEB-INF/file/");
//            if(!dir.exists()){
//                dir.mkdir();
//            }
//            File file = new File(dir+"/"+fileName);
//            os = new PrintWriter(new FileWriter(file));
//            byte[] bytes = new byte[1024];
//            String line = null;
//            while((line = br.readLine()) != null){
//                if(!line.contains(splitString)){
//                    os.println(line);
//                }
//            }
//            os.flush();
//            System.out.println("上传完成");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                os.close();
//                is.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }



        InputStream is = null;

        try{
            is = request.getInputStream();
            int len = request.getContentLength();
            byte[] bytes = new byte[len];
            BufferedInputStream bis = new BufferedInputStream(is);
            File dir = new File("/Users/zhaochengye/Documents/gitProject/gitUserHand/cms/target/cms/WEB-INF/file/");
            if(!dir.exists()){
                dir.mkdir();
            }
            File file = new File(dir+"/"+"myfile3.log");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            int size = -1;
            while ((size = bis.read(bytes))!=-1){
                System.out.println(getSplit(bytes));

                bos.write(bytes,0,size);
            }
            bos.close();
            bis.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private byte[] getSplit(byte[] source){

        String sourceStr = new String(source);
        if(sourceStr.indexOf("Boundary")!=-1){
            sourceStr = sourceStr.substring(sourceStr.indexOf("Boundary")+8,sourceStr.indexOf("\r\nContent-Disposition:"));
        }
        return  sourceStr.getBytes();
    }



}
