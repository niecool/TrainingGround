package com.jd.cms.test.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author zhaochengye
 * @date 2019/4/3 15:03
 */
public class ClientSocketTest {

    private Socket clientSocket = null;
    private BufferedWriter writer = null;
    private BufferedReader reader = null;
    private String msg = null;

    /**
     *
     */
    public void createClientSocket(){
        try {
            System.out.println("client starting");
            clientSocket = new Socket("127.0.0.1",2121);
            writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer.write("客户端：赵成业提交数据\\n");
            writer.flush();
            writer.close();

            System.out.println("=======");
            while ((msg = reader.readLine())!=null){
                System.out.println(msg);
                break;
            }
            msg = reader.readLine();
            if(msg!=null){
                System.out.println(msg);
            }else{
                System.out.println("返回空");
            }

            writer.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientSocketTest t = new ClientSocketTest();
        t.createClientSocket();
    }

}
