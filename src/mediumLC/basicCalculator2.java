package mediumLC;

import java.util.Stack;

public class basicCalculator2 {
    /**
     * 2 Approaches
     * 1. Using Stack.
     * 2. Using an int (lastNumber) instead of stack.
     */

    public static int basicCalculator2_Stack(String s){
        int result = 0;
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch = '0');
            }
            if(!Character.isDigit(ch) && ch == ' ' || i== s.length()-1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = ch;
            }
        }
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    public static int basicCalculator2_Int(String s){
        int result = 0;
        int currNum = 0, lastNum = 0;
        char sign = '+';
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum*10 + (ch-'0');
            }
            if(!Character.isDigit(ch) && ch == ' ' || i==s.length()-1){
                if(sign == '+' || sign == '-'){
                    //stack.push(currNum) or stack.push(-currNum)
                    result += lastNum;
                    lastNum = (sign == '+') ? currNum : -currNum;
                } else if(sign == '*'){
                    result = lastNum * currNum;
                } else if(sign == '/'){
                    result = lastNum / currNum;
                }
                currNum = 0;
                sign =  ch;
            }
        }
        result += lastNum;
        return result;
    }
}
