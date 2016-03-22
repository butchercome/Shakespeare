package com.cjw.file.io;

import java.io.*;

/**
 * 二进制文件的读取
 * Created by 828471 on 2015/11/17.
 */
public class BinaryFile {
    public static byte[] read(File file)throws IOException{
        BufferedInputStream bf=new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] data=new byte[bf.available()];
            bf.read(data);
            return  data;
        } finally {
            bf.close();
        }
    }
    public static  byte[] read(String fileName) throws  IOException{
        return  read(new File(fileName).getAbsolutePath());
    }
}
