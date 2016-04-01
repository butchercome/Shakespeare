package com.cjw.load.player;

import java.util.ArrayList;

/**
 * 游戏规则计算
 * 输入的是键值
 * 返回的是键位置。
 * Created by 828471 on 2015/11/26.
 */
public class PlayRules {
    /**
     *
     * @param cardArray 查询牌数组
     * @param i         查询位数
     * @return          如该位不存在牌则为空，如存在则返回牌位
     * 注意：返回的是牌位，其值将会加一
     */
    public static ArrayList check4Color(Integer[][]  cardArray,Integer i){
        ArrayList result=new ArrayList();
       //int length=cardArray[i].length;
        for(int j=0;j<cardArray[i].length;j++){
            if(cardArray[i][j]!=null)
                result.add(j);
        }
        return result;
    }
    /**
     * 当（单张）发牌或者出牌后，剩余的牌数数组
     * @param cardValue 出牌值
     * @param cardArray 出牌所在数组
     * @return          出牌后的剩余数组
     */
    public static Integer[][] cardremove(Integer cardValue, Integer[][] cardArray){
        Integer   colorNumber=SystemConstant.getColorNumber();
        for(int i=colorNumber-1;i>=0;i--){
            if(cardArray[i][cardValue-1]!=null){
                cardArray[i][cardValue-1]=null;
            }
        }
        return cardArray;
    }

    /**
     * 批量将牌从数组删除
     * @param cardValue 列表
     * @param cardArray 所在牌数组
     * @return          返回后数组
     */
    public static Integer[][] cardListRemove(ArrayList<Integer> cardValue, Integer[][] cardArray){
        for(int i=0;i<cardValue.size();i++){
            cardremove(cardValue.get(i),cardArray);
        }
        return cardArray;
    }
}
