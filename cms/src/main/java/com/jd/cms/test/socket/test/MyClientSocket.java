package com.jd.cms.test.socket.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author zhaochengye
 * @date 2019-04-09 17:29
 */
public class MyClientSocket {
    private static SocketChannel socketChannel = null;
    private static ByteBuffer byteBuffer = null;
    private static String msg = "你好，我是客户端";
    private static int count=0;

    public static void main(String[] args) throws IOException {
        Long startTime = System.currentTimeMillis();
        while(count<10000) {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 2222));
            byteBuffer = ByteBuffer.allocate(64);
            byteBuffer.clear();//写之前调用
            byteBuffer.put(msg.getBytes());
            byteBuffer.flip();//读之前调用 rewind继续写之前调用
            socketChannel.write(byteBuffer);

            byteBuffer.clear();
            if (socketChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                System.out.println(Charset.forName("UTF-8").newDecoder().decode(byteBuffer));
            }
            socketChannel.close();
            count++;
        }
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
