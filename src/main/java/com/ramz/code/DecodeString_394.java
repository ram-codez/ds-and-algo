package com.ramz.code;

import java.util.Stack;

public class DecodeString_394 {

    public String decodeString(String s) {

        Stack<Character> stack = new Stack();

        StringBuffer result = new StringBuffer();

        for(Character c: s.toCharArray()) {
            if(!c.equals(']')) {
                stack.push(c);
            } else {
                StringBuffer temp = new StringBuffer();

                while(!stack.peek().equals('[')){
                    Character poped = stack.pop();
                    temp.append(poped);
                }
                temp = temp.reverse();
                stack.pop();//pop [

                //Number can be multiple digits
                StringBuffer inte = new StringBuffer();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    inte.append(stack.pop());
                }

                int loop = Integer.parseInt(inte.reverse().toString());

                //Push to stack so that nested scenario is taken care
                for(int i=0; i<loop; i++) {
                    for(int j=0; j< temp.length();j++) {
                        stack.push(temp.toString().toCharArray()[j]);
                    }
                }
            }
        }
        StringBuffer remaining = new StringBuffer();
        while(!stack.isEmpty()) {
            remaining.append(stack.pop());
        }
        result.append(remaining.reverse());
        return result.toString();

    }

    public static void main(String[] args) {

        String input = "100[leetcode]";
        //String input = "3[a]";
        DecodeString_394 x = new DecodeString_394();
        System.out.println(x.decodeString(input));

    }
}
