package com.jd.cms.test.socket.learn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author zhaochengye
 * @date 2019-04-04 13:51
 */
public class ClientSocketTest2 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",2222));

        String msg = System.currentTimeMillis()+"消息："+"赵成业的消息";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
        byteBuffer.clear();
        byteBuffer.put(msg.getBytes());
        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }

        socketChannel.close();

    }

}
