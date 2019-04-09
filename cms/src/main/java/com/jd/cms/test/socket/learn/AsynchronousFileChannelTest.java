package com.jd.cms.test.socket.learn;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @author zhaochengye
 * @date 2019-04-04 14:25
 */
public class AsynchronousFileChannelTest {

    public static void main(String[] args) throws IOException {
        AsynchronousFileChannel fileChannel =
                AsynchronousFileChannel.open(Paths.get(""), StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        Future<Integer> operation = fileChannel.read(buffer, position);

        while(!operation.isDone());

        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();
    }
}
