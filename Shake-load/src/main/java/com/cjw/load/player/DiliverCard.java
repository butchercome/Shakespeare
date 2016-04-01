package com.cjw.load.player;

import java.util.ArrayList;
import java.util.List;

/**
 * 无花色分牌
 * Created by 828471 on 2015/11/25.
 */
public class DiliverCard {
    private static  Integer colorNumber;
    private static Integer cardSingleNumber;
    //private static ArrayList<Integer[][]> mycardForEvery=new ArrayList<Integer[][]>();
    //发牌
    public static ArrayList<Integer[][]> diliverCard(Integer number){
        ArrayList<Integer[][]> cardForEvery=new ArrayList<Integer[][]>();
        SystemConstant.setCardSingleNumber(number);
        colorNumber=SystemConstant.getColorNumber();
        cardSingleNumber=SystemConstant.getCardSingleNumber();
        List<Integer> cardList = NewBlankCard.shuffledList(number);
        Integer[][] A=new Integer[colorNumber][cardSingleNumber];
        Integer[][] B=new Integer[colorNumber][cardSingleNumber];
        Integer[][] C=new Integer[colorNumber][cardSingleNumber];
        Integer[][] D=new Integer[colorNumber][cardSingleNumber];
        Integer[][] remainCard=NewBlankCard.cardRemainArray(number);
        //对四人轮流发牌
        for(int i=0;i<cardList.size();i=i+4){
           // Integer cardValue=cardList.get(i);
            A=cardForPerson(A,cardList.get(i));

            B=cardForPerson(B,cardList.get(i+1));
            C=cardForPerson(C,cardList.get(i+2));
            D=cardForPerson(D,cardList.get(i+3));

        }
        cardForEvery.add(A);
        cardForEvery.add(B);
        cardForEvery.add(C);
        cardForEvery.add(D);
        return cardForEvery;
    }
    //将每人的牌对应到二维数组
    public static Integer[][] cardForPerson(Integer[][] cardArray ,Integer cardValue){
        for(int i=0;i<cardArray.length;i++){
            if(cardArray[i][cardValue-1]==null||cardArray[i][cardValue-1]<=0){
                cardArray[i][cardValue-1]=cardValue;
                break;
            }
        }
        return cardArray;
    }
    public static  void main (String[] args){
        ArrayList<Integer[][]> mycardForEvery=diliverCard(10);
        //Testmethod.printArray2(mycardForEvery.get(i));
        for(int i=0;i<mycardForEvery.size();i++){
           /* for(int j=0;j<mycardForEvery.get(i).length;j++){
                System.out.println(Arrays.asList(mycardForEvery.get(i)[j]));
            }*/
            Testmethod.printArray2(mycardForEvery.get(i));
        }
    }
}
