package com.jd.cms.test.socket.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author zhaochengye
 * @date 2019-04-09 09:52
 */
public class MyServerSocket {
    private static ServerSocketChannel serverSocketChannel = null;
    private static Selector selector;

    static {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SelectionKey selectionKey = null;


    public static void main(String[] args) throws IOException {
        System.out.println("1.开启selector。");
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 2222));
        System.out.println("2.获取serverSocketChannel，并绑定IP和端口。");
        serverSocketChannel.configureBlocking(false);
        selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("3.channel注册到selector里面去。");
        while (true) {
            if (selector.select(3000) == 0) {
                System.out.println("等待请求超时");
                continue;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(64));
                } else if (selectionKey.isConnectable()) {
                    System.out.println("isConnectable");
                } else if (selectionKey.isReadable()) {
                    System.out.println("isReadable");
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    byteBuffer.clear();
                    if (socketChannel.read(byteBuffer) == -1) {
                        socketChannel.close();
                    }else {
                        //将buffer转换为读状态
                        byteBuffer.flip();
                        //将buffer中接收到的值按localCharset格式编码后保存到receicedString
                        String receivedString = Charset.forName("UTF-8").newDecoder()
                                .decode(byteBuffer).toString();
                        System.out.println("receiced from client:" + receivedString);
                        byteBuffer.clear();
                        byteBuffer.put("我是服务端".getBytes());
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        socketChannel.close();
                    }


                } else if (selectionKey.isWritable()) {
                    System.out.println("isWritable");
                }
                iterator.remove();
                System.out.println("=======================================");
            }
            System.out.println("++++++++++++++++++++++");
        }

    }


}
