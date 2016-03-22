package com.cjw.player;

import java.util.ArrayList;

/**
 * 游戏开始
 * Created by 828471 on 2015/11/26.
 */
public class GameRun {
    private  static ArrayList<Integer[][]> cardForEvery;

    //游戏开始
    public static void runningGame(Integer number){
        //发牌四人得牌
        cardForEvery=DiliverCard.diliverCard(number);
        //打印每人牌
        Testmethod.printListArray2(cardForEvery);
        //四人牌到手
        Integer[][] A=cardForEvery.get(0);
        Integer[][] B=cardForEvery.get(1);
        Integer[][] C=cardForEvery.get(2);
        Integer[][] D=cardForEvery.get(3);
        //打印主牌
        System.out.println("....................................");
        Testmethod.printArray2(A);
        System.out.println("....................................1");
        ArrayList a=PlayRules.check4Color(A,2);
        Testmethod.printList(a);
        System.out.println("....................................2");




    }
    public static void main(String[] args){
        runningGame(10);
    }
}
