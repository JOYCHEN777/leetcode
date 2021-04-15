package JZOF;

import java.util.Deque;
import java.util.LinkedList;

public class T {

    public static void main(String[] args){
       Deque<Integer> d=new LinkedList<>();
       d.offer(1);
       d.push(2);
       d.offer(3);
       System.out.println(d.poll());
        System.out.println(d.poll());
        System.out.println(d.pop());
    }
    



}

