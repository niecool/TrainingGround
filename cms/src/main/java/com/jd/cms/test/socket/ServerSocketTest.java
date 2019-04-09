package com.jd.cms.test.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhaochengye
 * @date 2019/4/3 10:59
 */
public class ServerSocketTest {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    /**
     *
     */
    public void createServer() {
        try {
            serverSocket = new ServerSocket(2121, 2);
//            while (true) {
                System.out.println("准备连接...");
                socket = serverSocket.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String rec = bufferedReader.readLine();
                System.out.println(rec);
                bufferedWriter.write(rec);
                bufferedWriter.flush();
                while (true){

                }
//                System.out.println("server end");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ServerSocketTest t = new ServerSocketTest();
        t.createServer();
    }

}
