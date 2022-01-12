package com.ramz.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceSorting_1859 {

    public static void main(String[] args) {

        String s = "Myself2 Me1 I4 and3";
        System.out.println(getCorrectSentence(s));
    }

    public static String getCorrectSentence(String input) {

        String[] inputArr = input.split(" ");

        String[] output = new String[inputArr.length];

        for(String s: inputArr) {
            int pos = Integer.parseInt(s.substring(s.length()-1));
            output[pos-1] = s.substring(0,s.length()-1);
        }

        int i =0;
        StringBuffer sb = new StringBuffer();
        for(String s : output) {
            sb.append(s);
            if(i != output.length-1) {
                sb.append(" ");
            }
            i++;
        }

        return sb.toString();
    }
}
