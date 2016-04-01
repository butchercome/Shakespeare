package com.cjw.load.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * ���ڴ�����
 * Created by 828471 on 2015/11/17.
 */
public class MemoryInput {
    public static  void main (String[] args) throws IOException{
        StringReader in=new StringReader(BufferInputFile.read("E:\\ucmp.txt"));
        int c;
        while((c=in.read())!=-1)
            System.out.println((char)c);
    }
}
