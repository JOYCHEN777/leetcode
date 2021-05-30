package BS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class XC1 {
    public static int max=0;
    static int procee(int[] scores, int[] cards) {
        if(cards.length==0){
            return scores[0];
        }
        int res=0;
        boolean[] v=new boolean[cards.length];
        dfs(v,scores,cards,res,0,0);
        return max;

    }
    static void dfs(boolean[] v, int[] scores, int[] cards,  int res, int loc, int t){
        if(t==v.length){
           max=Math.max(res+scores[loc],max);
            return;
        }
        //res+=scores[loc];

        for(int i=0;i<cards.length;i++){
            if(!v[i]){
                v[i]=true;
                dfs(v,scores,cards,res+scores[loc],loc+cards[i],t+1);
                v[i]=false;
            }
        }
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        int _scores_size = 0;
        _scores_size = Integer.parseInt(in.nextLine().trim());
        int[] _scores = new int[_scores_size];
        int _scores_item;
        for(int _scores_i = 0; _scores_i < _scores_size; _scores_i++) {
            _scores_item = Integer.parseInt(in.nextLine().trim());
            _scores[_scores_i] = _scores_item;
        }

        int _cards_size = 0;
        _cards_size = Integer.parseInt(in.nextLine().trim());
        int[] _cards = new int[_cards_size];
        int _cards_item;
        for(int _cards_i = 0; _cards_i < _cards_size; _cards_i++) {
            _cards_item = Integer.parseInt(in.nextLine().trim());
            _cards[_cards_i] = _cards_item;
        }
        res = procee(_scores, _cards);
        System.out.println(String.valueOf(res));

    }
}
