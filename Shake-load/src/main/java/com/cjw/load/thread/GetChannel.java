package com.cjw.load.thread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 新i/o   FileChannel
 * Created by 828471 on 2015/11/18.
 */
public class GetChannel {
    public  static final int BSIZE=1024;
    public static void main(String[] args)throws Exception{
        FileChannel fc=new FileOutputStream("E:\\ucmp.txt").getChannel();
        fc.write(ByteBuffer.wrap("E:\\test.log".getBytes()));
        fc.close();
        fc=new RandomAccessFile("E:\\ucmp.txt","rw").getChannel();
        fc.write(ByteBuffer.wrap("E:\\test.log".getBytes()));
        fc.close();
        fc=new FileInputStream("E:\\ucmp.txt").getChannel();
        ByteBuffer buff=ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char)buff.get());
    }
}
