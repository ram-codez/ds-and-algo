package com.ramz.code;

import java.util.HashSet;
import java.util.Set;

public class StringDiffByOneChar_1554 {

    public boolean differByOne(String[] dict) {

        Set<String> set = new HashSet<>();
        int len = dict[0].length();

        for(int i=0; i < len; i++) {
            set.clear();

            for(String word: dict) {
                String part = word.substring(0,i) + word.substring(i+1, len);
                if(set.contains(part)) {
                    return true;
                } else {
                    set.add(part);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] input = {"abcd","cccc","abyd","abab"};

        StringDiffByOneChar_1554 temp = new StringDiffByOneChar_1554();
        System.out.println(temp.differByOne(input));
    }
}
