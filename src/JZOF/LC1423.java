package JZOF;

import java.util.Stack;

public class LC1423 {
    /*
    * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
你的点数就是你拿到手中的所有卡牌的点数之和。
给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
。*/
    //其实可以维护中间一段最小窗口
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int min=0;
        int n=cardPoints.length-k;
        for(int i=0;i<cardPoints.length;i++){
            sum+=cardPoints[i];
            if(i<n){
                min+=cardPoints[i];
            }
        }
        int left=0;
        int temp=min;
        for(int i=n;i<cardPoints.length;i++){
            temp=temp-cardPoints[left]+cardPoints[i];
            min=Math.min(min,temp);
            left++;
        }
        return sum-min;
    }

}
/*
*       int res=0;
        if(k==1){
            return cardPoints[0]>=cardPoints[cardPoints.length-1]?cardPoints[0]:cardPoints[cardPoints.length-1];
        }
        if(k==cardPoints.length){
            for(int i=0;i<cardPoints.length;i++){
                res+=cardPoints[i];
            }
            return res;
        }
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<k;i++){
            stk.push(cardPoints[i]);
            res+=cardPoints[i];
        }
        int temp=res;
        for(int i=0;i<k;i++) {
            temp -= stk.pop();
            temp +=cardPoints[cardPoints.length-1-i];
            res=Math.max(temp,res);

        }
        return res;
* */