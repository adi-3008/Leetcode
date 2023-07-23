package stack;

import java.util.Stack;

public class InfixToPostFix {

    public static String infixToPostfix(String exp) {
        // Your code here

        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(char ch : exp.toCharArray()){

            if(isOperand(ch)){
                sb.append(ch);
            }
            else if(isOperator(ch)){
                while(!st.isEmpty() && !isOpeningnParen(st.peek()) && hasHigherPrecedence(st.peek(), ch))
                    sb.append(st.pop());
                st.push(ch);
            }
            else if(isOpeningnParen(ch)){
                st.push(ch);
            }
            else{
                while(!st.isEmpty() && !isOpeningnParen(st.peek()))
                    sb.append(st.pop());
                st.pop();
            }
        }

        while (!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();

    }

    static boolean isOperand(char ch){
        return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || '0' <= ch && ch <= '9';
    }

    static boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^';
    }

    static boolean isOpeningnParen(char ch){
        return ch == '(';
    }

    static boolean hasHigherPrecedence(char ch1, char ch2){
        if(ch1 == '^')
            return true;
        else if(ch2 == '^')
            return false;

        if((ch1 == '/' || ch1 == '*'))
            return true;
        else if(ch2 == '/' || ch2 == '*')
            return false;

        return true;

    }

}
