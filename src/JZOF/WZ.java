package JZOF;



/**

 * 在这座村庄一共有n个勇士，
 * 他们每个人都有一定的武力值ai，他们先后报名去击败怪兽。
 * 在排队的时候，他们会不自禁的比较起来，每个人都会挑战他前面的人。
 * 例如小明想挑战他前面的勇士小红，如果小明胜利的话，小红会认为小明比自己更适合击败怪兽，将会羞愧离去。
 * 如果小红胜利的话，小明会认为如果小红失败，自己可能还会有机会上场。
 * 也就是说，如果一个人被后面的人击败，会放弃挑战怪兽，如果挑战前面的人失败，会留在队中。
 * 挑战前面的人成功之后，可以继续挑战。挑战前面的人失败，被后面的人挑战成功的话仍会离去。
 * 武力值高者胜，相等则没有人离去。
 * 请你按顺序给出最终挑战怪兽的勇士的武力值。
 */
import java.util.Scanner;
import java.util.Stack;
public class WZ {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Stack<Integer> stk=new Stack<>();
        stk.push(arr[0]);
        for(int i=1;i<n;i++){
            while(!stk.isEmpty()){
                if(arr[i]>stk.peek()){
                    stk.pop();
                }else{
                    //stk.push(arr[i]);
                    break;
                }
            }
            stk.push(arr[i]);
        }
        Stack<Integer> res=new Stack<>();
        int ans=0;
        while(!stk.isEmpty()){
            ans++;
            res.push(stk.pop());
        }
        System.out.println(ans);
        while(!res.isEmpty()){
            System.out.print(res.pop());
            System.out.print(" ");
        }
    }

}
