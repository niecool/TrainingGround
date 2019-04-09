package com.jd.cms.test.socket.learn;

import org.apache.ibatis.annotations.SelectKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author zhaochengye
 * @date 2019-04-04 12:54
 */
public class ServerSocketTest2 {

    public static void main(String[] args) throws IOException {
        int bufferSize = 1024;
        String localCharset = "UTF-8";

        Selector selector = Selector.open();
        ServerSocketChannel channel1 = ServerSocketChannel.open();
        ServerSocketChannel channel2 = ServerSocketChannel.open();
        System.out.println(channel1==channel2?true:false);
        channel1.socket().bind(new InetSocketAddress("localhost",2222));
        channel1.configureBlocking(false);
        SelectionKey key = channel1.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("channel已经注册到register里面");
        while (true) {
            if (selector.select(3000) == 0) {
                System.out.println("等待请求超时......");
                continue;
            }
            System.out.println("处理请求......");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    if(selectionKey.isAcceptable()){
                        SocketChannel socketChannel = ((ServerSocketChannel)selectionKey.channel()).accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ,bufferSize);

                    }
                    if(selectionKey.isReadable()){
                        SocketChannel sc =  (SocketChannel)selectionKey.channel();
                        ByteBuffer buffer = (ByteBuffer)key.attachment();
                        buffer.clear();
                        if (sc.read(buffer) == -1) {
                            sc.close();
                        } else {
                            //将buffer转换为读状态
                            buffer.flip();
                            //将buffer中接收到的值按localCharset格式编码后保存到receicedString
                            String receivedString = Charset.forName(localCharset).newDecoder()
                                    .decode(buffer).toString();
                            System.out.println("receiced from client:" + receivedString);

                            //返回数据给客户端
                            String sendString = "received data:" + receivedString;
                            buffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
                            sc.write(buffer);
                            //关闭Socket
                            sc.close();
                        }
                    }
                }
        }

    }

}
