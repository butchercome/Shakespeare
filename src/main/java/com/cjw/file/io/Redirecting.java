package com.cjw.file.io;

import java.io.*;

/**标准io重定向
 * Created by 828471 on 2015/11/17.
 */
public class Redirecting {
    public static  void main (String[] args)throws IOException{
        PrintStream console=System.out;
        BufferedInputStream in=new BufferedInputStream(new FileInputStream("E:\\ucmp.txt"));
        PrintStream out =new PrintStream(new BufferedOutputStream(new FileOutputStream("E:\\test.log")));
        System.setIn(in);
        System.setOut(out);   //关键点：将输出地址指向out，所以在控制台看不到输出
        System.setErr(out);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null)
            System.out.println(s);
        out.close();
        System.setOut(console);

    }
}
