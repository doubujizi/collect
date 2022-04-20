package com.dou.tfx.prefect.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/1/28 7:43 下午
 */
public class NIOServer2 {
    public static void main(String[] args) throws Exception {
        //1、创建网络服务端ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //2、构建一个Selector选择器，并且将channel注册上去
        Selector selector = Selector.open();
        //将ServerSocketChannel 注册到selector
        SelectionKey selectionKey = serverSocketChannel.register(selector, 0, serverSocketChannel);
        //对ServerSocketChannel上面的accept时间感兴趣（severSocketChannel只能支持accept操作）
        selectionKey.interestOps(SelectionKey.OP_ACCEPT);

        //3、绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        System.out.println("启动成功");

        while (true) {
            //不在轮询通道 改用下面轮询事件的方式select方法有阻塞效果，直到有事件通知才返回
            selector.select();
            //获取事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                //只关注 Read 和 Accept两个事件
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.attachment();
                    //将拿到的客户端连接通道 注册到selector上面
                    SocketChannel clientSocketChannel = server.accept();
                    clientSocketChannel.configureBlocking(false);
                    clientSocketChannel.register(selector, SelectionKey.OP_READ, clientSocketChannel);
                    System.out.println("收到新连接：" + clientSocketChannel.getRemoteAddress());
                }

                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.attachment();
                    ByteBuffer requestBuffer = ByteBuffer.allocate(1024);
                    while (socketChannel.isOpen() && socketChannel.read(requestBuffer)!=-1){
                        //长连接情况下 需要手动判断数据有没有读取结束（此处做一个简单判断：超过0字节就可以认为请求结束了）
                        if(requestBuffer.position() > 0){
                            break;
                        }
                    }
                    if (requestBuffer.position()==0){
                        continue;
                    }
                    requestBuffer.flip();
                    byte[] content = new byte[requestBuffer.limit()];
                    System.out.println(new String(content));
                    System.out.println("收到数据,来自："+socketChannel.getRemoteAddress());

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
}
