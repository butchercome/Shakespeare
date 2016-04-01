package com.cjw.load.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 格式化的内存输入(DataInputStream)
 * 分别为字节和字符。注意区分不同的装饰器下不同的方法
 * Created by 828471 on 2015/11/17.
 */
public class FormatedMemoryInput {
    public static void main(String[] args)throws IOException{
        try {
            DataInputStream in=new DataInputStream(new ByteArrayInputStream(BufferInputFile.read("E:\\ucmp.txt").getBytes()));
            while(true)
                System.out.println((char)in.readByte());
            /*DataInputStream in =new DataInputStream(new BufferedInputStream(new FileInputStream("E:\\ucmp.txt")));
            while ((in.available())!=0)
                System.out.println((char)in.readByte());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
