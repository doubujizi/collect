package com.dou.tfx.prefect.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/1/28 7:24 下午
 */
public class NIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
        while (!socketChannel.finishConnect()) {
            //没连接上 一直等待
            Thread.yield();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        //发送内容
        String msg = scanner.nextLine();
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        //读取响应
        System.out.println("收到服务端响应：");
        ByteBuffer requestBuffer = ByteBuffer.allocate(1024);

        while (socketChannel.isOpen() && socketChannel.read(requestBuffer) != -1) {
            if (requestBuffer.position() > 0) {
                break;
            }
        }
        requestBuffer.flip();
        byte[] content = new byte[requestBuffer.limit()];
        requestBuffer.get(content);
        System.out.println(new String(content));
        scanner.close();
        socketChannel.close();
    }
}
