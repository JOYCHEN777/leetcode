package JZOF;

import java.util.Arrays;
import java.util.HashMap;

public class LC765 {
    /*N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。
     计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。
     一次交换可选择任意两人，让他们站起来交换座位。
人和座位用0到2N-1的整数表示，情侣们按顺序编号，第一对是(0, 1)，第二对是(2, 3)，以此类推，最后一对是(2N-2, 2N-1)。
这些情侣的初始座位row[i]是由最初始坐在第 i 个座位上的人决定的。
*/
    public int minSwapsCouples(int[] row) {
        int count=0;
        int[] locate=new int[row.length];
        int[] arr=new int[row.length];
        Arrays.fill(arr,-1);
        for(int i=0;i<(row.length)/2;i++){
            if(isCouple(row,i)){
                count++;
            }else{
                arr[row[2*i]]=row[2*i+1];
                //i号情侣的位置为locate[i];
                locate[row[i]]=i;
            }
        }
        if(count==(row.length)/2){
            return 0;
        }
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=-1&&!isC(i,arr[i])){
                res++;
                int a=arr[i];
                int b=findC(a);

            }
        }
        return 0;
    }
    public int findC(int i){
        return i%2==0?i+1:i-1;
    }
    public boolean isC(int i,int j){
        int a=Math.min(i,j);
        int b=Math.max(i,j);
        if(a%2==0&&b==a+1){
            return true;
        }
        return false;
    }
    public boolean isCouple(int[] row,int i){
        int men=row[2*i];
        if(men%2==0){
            if(row[2*i+1]==men+1){
                return true;
            }
        }
        else{
            if(row[2*i+1]==men-1){
                return true;
            }
        }
        return false;
    }
}
