package com.ramz.code;

import java.util.Arrays;

public class ArrayConcatenation_1929 {

    public static void main(String[] args) {
        //int[] input = {1,2,3,4};
        int[] input = {};
        System.out.println(Arrays.toString(concatenate(input)));
    }

    public static int[] concatenate(int[] input) {

        int[] result = new int[input.length *2];

        for(int i=0; i< input.length;i++) {
            result[i] = input[i];
            result[i+input.length] = input[i];
        }
        return result;
    }
}
