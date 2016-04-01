package com.cjw.load.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 无花色分牌
 * Created by 828471 on 2015/11/25.
 */
public class NewBlankCard {
    public static final int colorNumber=4;
    public static List<Integer> newCard;
    public static List<Integer> shuffledCard;
    public static Integer[][] cardArray;
    /**
     * 创建不分花色的牌
     * @param number
     * @return
     */
    public static List<Integer>  newCardBlank(Integer number){
        SystemConstant.setCardSingleNumber(number);
        SystemConstant.setCardTotalNumber(number*SystemConstant.getColorNumber());
        List<Integer> cardList=new ArrayList<Integer>();
        for(int i=1;i<=number;i++){
            Integer[] card=new Integer[4];
            card[0]=i;
            card[1]=i;
            card[2]=i;
            card[3]=i;
            List<Integer> myCard = Arrays.asList(card);
            cardList.addAll(myCard);
        }
         //Collections.shuffle(cardList);
        return cardList;
    }

    /**
     * 对不分花色的牌洗牌
     * @param number
     * @return
     */
    public static List<Integer> shuffledList(Integer number){
        shuffledCard=newCardBlank(number);
        Collections.shuffle(shuffledCard);
        return shuffledCard;
    }

    /**
     * 剩余牌二维素组
     * @param number
     * @return
     */
    public static Integer[][] cardRemainArray(Integer number){
        newCard=newCardBlank(number);
        Integer[][] cardArray=new Integer[colorNumber][number];
        for(int i=0;i<colorNumber;i++){
            for(int j=0;j<number;j++){
                cardArray[i][j]=j+1;
            }
        }
        return cardArray;
    }
    public static void main(String args[]){
        shuffledCard=shuffledList(10);
        newCard=newCardBlank(10);
        cardArray=cardRemainArray(10);
        for(int i=0;i<cardArray.length;i++){
            for(int j=0;j<cardArray[i].length;j++){
                System.out.print(cardArray[i][j]);

            }
            System.out.println(Arrays.asList(cardArray[i]));
        }
        System.out.println(cardArray);
    }
}
