package com.cjw.file.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 828471 on 2015/11/17.
 */
public class Echo {
    public static void main(String[] args)throws IOException{
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        String  s;
        while ((s=stdin.readLine())!=null&&s.length()!=0)
            System.out.println(s.toUpperCase());
    }
}
