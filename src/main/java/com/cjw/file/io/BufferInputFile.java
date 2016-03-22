package com.cjw.file.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲输入文件
 * Created by 828471 on 2015/11/17.
 */
public class BufferInputFile {
    public static String read(String   fileName) throws IOException{
        BufferedReader  in =new BufferedReader(new FileReader(fileName));
        String s;
        StringBuffer sb= new StringBuffer();
        while((s=in.readLine())!=null)
            sb.append(s+"\n");
        in.close();
        return  sb.toString();
    }
    public static void main(String[] args)throws IOException{
        System.out.println(read("E:\\ucmp.txt"));
    }
}
