package JZOF;

import java.util.Stack;

public class LC20 {
    /*有效括号*/
    public static boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stk.push(')');
            }else if(c=='['){
                stk.push(']');
            }else if(c=='{'){
                stk.push('}');
            }else if(stk.isEmpty()||c!=stk.pop()){
                return false;
            }

        }
        return stk.isEmpty();
    }
}
   /* public static boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<=s.length()-1;i++){
            if(stk.isEmpty()){
                stk.push(s.charAt(i));
            }else{
                if(verify(stk.peek(),s.charAt(i))){
                    stk.pop();
                }else{
                    stk.push(s.charAt(i));
                }
            }
        }
        return stk.isEmpty();
    }
    public static boolean verify(char x, char y){
        if(x=='('&&y==')'){
            return true;
        }
        if(x=='['&&y==']'){
            return true;
        }
        if(x=='{'&&y=='}'){
            return true;
        }
        return false;
    }*/

