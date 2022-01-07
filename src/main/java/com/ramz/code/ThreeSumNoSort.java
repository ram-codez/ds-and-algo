package com.ramz.code;

import java.util.*;

public class ThreeSumNoSort {

    public static void main(String[] args) {

        int[] input = {1,2,3,5,4,7,8,6,9};
        //int[] input = {1,2};
        //int[] input = {1};
        //int[] input = {};
        System.out.println(getThreeSum(input, 9));
    }

    public static List<List<Integer>> getThreeSum(int[] input, int target) {

       List<List<Integer>> result = new ArrayList<List<Integer>>();
       Map<Integer,Integer> seen = new HashMap<>();

       for(int i=0; i< input.length;i++) {
           System.out.println("i:" + i);
           for(int j=i+1;j<input.length;j++) {
               System.out.print(" j:" + j);
               int compliment = target - input[i] - input[j];
                if(seen.containsKey(compliment) && seen.get(compliment) == i){
                    result.add(Arrays.asList(input[i], input[j], compliment));
                }
                seen.put(input[j], i);
               System.out.println("," + seen);
           }
       }

       return result;
    }

}
