package com.ramz.code;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis_20 {

    public static void main(String[] args) {

        String s = "()[]{}";
        ValidParenthesis_20 v = new ValidParenthesis_20();

        System.out.println(v.isValid(s));
    }

    public boolean isValid(String s) {

        HashMap<Character,Character> bracs = new HashMap<>();
        bracs.put(')','(');
        bracs.put(']','[');
        bracs.put('}','{');

        Stack<Character> stack = new Stack<>();


        for(int i = 0; i < s.length();i++) {

            Character c = s.charAt(i);
            // If the current character is a closing bracket.
            if(bracs.containsKey(c)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value
                Character found = stack.empty() ? '$' : stack.pop();
                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if(found != bracs.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
