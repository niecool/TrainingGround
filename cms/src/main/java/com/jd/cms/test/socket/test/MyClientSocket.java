package com.jd.cms.test.socket.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author zhaochengye
 * @date 2019-04-09 17:29
 */
public class MyClientSocket {
    private static SocketChannel socketChannel = null;
    private static ByteBuffer byteBuffer = null;
    private static String msg = "你好，我是客户端";

    public static void main(String[] args) throws IOException {
        socketChannel= SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",2222));
        byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.clear();
        byteBuffer.put(msg.getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        socketChannel.close();

    }
}
