package com.cjw.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试方法
 * Created by 828471 on 2015/11/26.
 */
public class Testmethod {
    /**
     * 打印二维数组
     * @param cardArray
     */
    public static void printArray2(Integer[][] cardArray){
        for(int length=0;length<cardArray.length;length++){
            System.out.println(Arrays.asList(cardArray[length]));
        }
    }
    public static void printListArray2(ArrayList<Integer[][]> cardArrayList){
        for(int i=0;i<cardArrayList.size();i++){
            printArray2(cardArrayList.get(i));
        }
    }
    public static void printList(ArrayList cardExitList){
        for(int i=0;i<cardExitList.size();i++){
            System.out.print(cardExitList.get(i) + "    ");
        }
        System.out.println();
    }
    public static void  main(String[] args) {
        String sss = "1;12;2121;2121";
        String[] aa = sss.split(";");
        List<String> ss = Arrays.asList(aa);
        for (String a : ss) {
            System.out.println(a);
        }
    }


    }

