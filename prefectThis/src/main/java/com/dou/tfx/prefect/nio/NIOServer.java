package com.dou.tfx.prefect.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/1/26 8:38 下午
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        System.out.println("启动成功");
        while (true){
            //获取新tcp连接通道
            SocketChannel socketChannel = serverSocketChannel.accept();
            //tcp 请求/响应
            if(socketChannel!=null){
                System.out.println("收到新连接："+socketChannel.getRemoteAddress());
                //默认是阻塞的一定要设置非阻塞
                socketChannel.configureBlocking(false);
                ByteBuffer requestBuffer = ByteBuffer.allocate(1024);
                while (socketChannel.isOpen() && socketChannel.read(requestBuffer) != -1){
                    //长连接情况下，需要手动判断数据有没有读取结束（此处做一个简单的判断：超过0字节就可以认为请求结束了）
                    if(requestBuffer.position() >0){
                        break;
                    }
                }
                //如果没有数据了则不继续后面处理
                if (requestBuffer.position() == 0){
                    continue;
                }
                requestBuffer.flip();
                byte[] content = new byte[requestBuffer.limit()];
                requestBuffer.get(content);
                System.out.println(new String(content));

                System.out.println("收到数据，来自：" + socketChannel.getRemoteAddress());

                //响应结果200
                String response = "HTTP/1.1 200 OK\r\n"+
                        "Content-Length: 11\r\n\r\n"+
                        "HelloWorld";
                ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
                while (buffer.hasRemaining()){
                    socketChannel.write(buffer);
                }
            }
        }
    }
}
