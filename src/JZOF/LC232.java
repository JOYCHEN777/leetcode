package JZOF;

import java.util.Stack;

public class LC232 {
    /**
     * 两个stcak实现一个队列
     */
    /**
     * Initialize your data structure here.
     */
    Stack<Integer> in;
    Stack<Integer> out;

    public LC232() {
        Stack<Integer> in=new Stack<>();
        Stack<Integer> out=new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if(!out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if(!out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return (in.isEmpty()&& out.empty());

    }
    public static void main(String[] args){
        int i=0;
        System.out.println(i);
        test(i);
        System.out.println(i);
    }
    public static void test(int i){
        i=i+2;
        System.out.println(i);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */