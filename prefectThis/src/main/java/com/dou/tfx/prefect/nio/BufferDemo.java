package com.dou.tfx.prefect.nio;

import java.nio.ByteBuffer;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/1/26 7:57 下午
 */
public class BufferDemo {
    public static void main(String[] args) {
        //构建一个byte字节缓冲区，容量是4
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        //默认写入模式，查看重要的指标
        System.out.println(String.format("初始化：capacity容量：%s，position位置：%s，limit限制：%s",
                byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));
        //写入几字节的数据
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 3);
        //再看数据
        System.out.println(String.format("放入3个字节后：capacity容量：%s，position位置：%s，limit限制：%s",
                byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));
        //转换为读取模式(不调用flip方法，也是可以读取数据的，但是position记录读取的位置不对)
        System.out.println("##########开始读取");
        byteBuffer.flip();
        byte a = byteBuffer.get();
        System.out.println(a);
        byte b = byteBuffer.get();
        System.out.println(b);
        System.out.println(String.format("读取2个字节后：capacity容量：%s，position位置：%s，limit限制：%s",
                byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));
        //继续写入3字节，此时读模式下，limit=3，position=2继续写入只能覆盖写入一条数据
        //clear()方法清除整个缓冲区。compact（）方法仅清除已阅读的数据。转为写入模式
        byteBuffer.compact();
        byteBuffer.put((byte) 3);
        byteBuffer.put((byte) 4);
        byteBuffer.put((byte) 5);
        System.out.println(String.format("最终的情况：capacity容量：%s，position位置：%s，limit限制：%s",
                byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));

        //remind()重置position为0
        //mark()标记position位置
        //reset() 重置position为上次mark()标记位置
        //堆外内存申请
        //ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(4);

    }
}
