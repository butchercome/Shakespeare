package com.cjw.load.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 文件读写实用工具
 * Created by 828471 on 2015/11/17.
 */
public class TextFile extends ArrayList<String> {
    public static  String read(String fileName) {
        StringBuilder sb=new StringBuilder();
        try {
            BufferedReader in=new BufferedReader(new FileReader(new File(fileName).getAbsolutePath()));
            try {
                String s;
                while ((s=in.readLine())!=null){
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
        return  sb.toString();
    }
    public  static  void write(String fileName,String text){
        try {
            PrintWriter out =new PrintWriter(new File(fileName).getAbsolutePath());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
           throw  new RuntimeException(e);
        }
    }
    //读取file，通过splitter将其分割
    public TextFile(String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals(""))
            remove(0);
    }
    //普通文件逐行读取
    public TextFile(String fileName){
        this(fileName, "\n");
    }
    public void write(String fileNmae){
        try {
            PrintWriter out=new PrintWriter(new File(fileNmae).getAbsolutePath());
            try {
                for (String item:this){
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw  new RuntimeException(e);
            }
    }
    public static void main (String[] args){
        String file= read("E:\\ucmp.txt");
        write("E:\\test.txt", file);
        TextFile text=new TextFile("E:\\test.txt");
        text.write("E:\\test2.txt");
        TreeSet<String> words=new TreeSet<String>(new TextFile("E:\\ucmp.txt","\\w+"));
        System.out.println(words.headSet("a"));
    }
}

