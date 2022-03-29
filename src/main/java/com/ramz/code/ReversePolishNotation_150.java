package com.ramz.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation_150 {

    public int evalRPN(String[] tokens) {

        Stack<String> st = new Stack();

        Set<String> expressions = new HashSet<>(Arrays.asList("+","-","*","/"));

        for(String token: tokens) {

            if(!expressions.contains(token)) {
                //push and move on
                st.push(token);
            } else {
                //evaluate and push
                String exp = token;
                int operand1 = Integer.parseInt(st.pop());
                int operand2 = Integer.parseInt(st.pop());

                Integer result = 0;
                if(exp.equals("+")) {
                    result = operand1 + operand2;
                } else if(exp.equals("-")) {
                    result = operand1 - operand2;
                } else if(exp.equals("*")) {
                    result = operand1 * operand2;
                } else if(exp.equals("/")) {
                    result = operand2 / operand1;
                }


                st.push(result.toString());
            }
        }

        return Integer.parseInt(st.pop());
    }

    public static void main(String[] args) {

        String[] input = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        ReversePolishNotation_150 x = new ReversePolishNotation_150();


        System.out.println(x.evalRPN(input));
    }
}
