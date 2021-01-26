package JZOF;
/*一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
*/
public class JZ9 {
    public int hentaiJumpFloor(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int res=0;
        for(int i=1;i<n;i++){
            res+=hentaiJumpFloor(n-i);

        }
     return res;
    }
}
