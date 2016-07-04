package com.cjw.load.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by 828471 on 2015/11/18.
 */
public class OSExcute {
    public static void command(String command){
        boolean err=false;
        try {
//            String[] sss=command.split(" ");
            Process process=new ProcessBuilder(command.split(" ")).start();
            BufferedReader results=new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while((s=results.readLine())!=null)
                System.out.println(s);
            BufferedReader erros=new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while((s=erros.readLine())!=null){
                System.out.println(s);
                err=true;
            }
        } catch (Exception e) {
            if(command.startsWith("CMD/C"))
                command("CMD/C"+command);
            else
                throw  new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        StringBuffer aaa=new StringBuffer();

        String  aa= null;
        String  bb=null;
        String  cc=null;
        String  dd=aa+bb+cc+"";
        aaa.append(aa).append(bb).append(cc);
        System.out.println(dd.toString());
        System.out.println(aaa.toString());
    }
}
