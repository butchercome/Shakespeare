package com.cjw.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  有花色分牌
 * Created by 828471 on 2015/11/25.
 */
public class NewCardWithColor {
    public static List<String> newCard;
    public static List<String> shuffledCard;

    /**
     * 创建包含花色的牌
     * @param number
     * @return
     */
    public static List<String>  newCardWithColor(Integer number){
        List<String> cardList=new ArrayList<String>();
        for(int i=1;i<=number;i++){
            String[] card=new String[4];
            card[0]=i+"a";
            card[1]=i+"b";
            card[2]=i+"c";
            card[3]=i+"d";

            List<String> myCard = Arrays.asList(card);
            cardList.addAll(myCard);
        }
        //Collections.shuffle(cardList);
        return cardList;
    }

    /**
     * 对包含花色的牌洗牌
     * @param number
     * @return
     */
    public static List<String> shuffledList(Integer number){
        shuffledCard=newCardWithColor(number);
        Collections.shuffle(shuffledCard);
        return shuffledCard;
    }
    public static void main(String args[]){
        shuffledCard=shuffledList(10);
        newCard=newCardWithColor(10);
        System.out.println(newCard);
    }
}
