package com.cjw.file.io.thread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 828471 on 2015/11/18.
 */
public class ChannelCopy {
    public static final int BSIZE=1024;
    public static void main (String[] args)throws Exception{
        if(args.length != 2){
            System.out.println("Source File destfile");
            System.exit(1);
        }
        FileChannel in= new FileInputStream(args[0]).getChannel();
        FileChannel out=new FileOutputStream(args[1]).getChannel();
        ByteBuffer buff=ByteBuffer.allocate(BSIZE);
        while((in.read(buff))!=-1){
            buff.flip();
            out.write(buff);
            buff.clear();
        }
    }
}
