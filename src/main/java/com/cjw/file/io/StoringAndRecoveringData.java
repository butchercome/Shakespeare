package com.cjw.file.io;

import java.io.*;

/**
 * 存储和数据恢复
 * Created by 828471 on 2015/11/17.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args)throws IOException{
        DataOutputStream out =new DataOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\ucmp.txt")));
        out.writeDouble(3.1415926);
        out.writeUTF("sssssss");
        out.close();
        DataInputStream in =new DataInputStream(new BufferedInputStream(new FileInputStream("E:\\ucmp.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

    }
}
