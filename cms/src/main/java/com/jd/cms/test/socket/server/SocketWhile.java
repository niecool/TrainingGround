package com.jd.cms.test.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketWhile {

    public static void main(String[] args) {
        ServerSocket socket = null;

        try {
            socket = new ServerSocket(2121);
            while (true) {
                System.out.println("sdfgdsasdf");
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.accept().getInputStream()));
                String a = in.readLine();
                System.out.println(a);
            }
        }catch (Exception e){
            System.out.println("socket 异常");
        }
    }
}
