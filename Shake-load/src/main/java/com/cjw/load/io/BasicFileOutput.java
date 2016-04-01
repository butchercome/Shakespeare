package com.cjw.load.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**基本的文件输出（添加行号）
 * 注意注释两种不同方法
 * Created by 828471 on 2015/11/17.
 */
public class BasicFileOutput {
    static String file="E:\\ucmp.txt";
    public static void main(String[] args)throws IOException{
        BufferedReader in=new BufferedReader(new StringReader(BufferInputFile.read(file)));
       // PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file)));
        PrintWriter out=new PrintWriter(file);//文本文件输出的快捷方式
        int lineCount=1;
        String s;
        while((s=in.readLine())!=null)
            out.println(lineCount++ +":"+s );
        out.close();
        System.out.println(BufferInputFile.read(file));
    }
}
