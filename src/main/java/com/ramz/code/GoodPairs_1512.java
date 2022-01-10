package com.ramz.code;

import java.lang.reflect.Array;
import java.util.*;

public class GoodPairs_1512 {

    public static void main(String[] args) {

        int[] input = {1,2,3,1,1,3};
        //int[] input = {1,1,1,1};
        //int[] input = {1,2,3};
        //System.out.println(getGoodPairsDoubleLoop(input));

        System.out.println(getGoodPairsWithMap(input));
    }

    public static int getGoodPairsDoubleLoop(int[] input) {

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i< input.length-1; i++) {
            for(int j=i+1; j< input.length;j++) {
                if(input[i] == input[j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result.size();
    }

    public static int getGoodPairsWithMap(int[] input) {

        Map<Integer, List<Integer>> lookupMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i< input.length; i++) {
            if(lookupMap.containsKey(input[i])){
                lookupMap.get(input[i]).add(i);
            } else {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                lookupMap.put(input[i], positions);
            }
        }
        for(int i = 0; i< input.length-1; i++) {

            if(lookupMap.containsKey(input[i])) {
                List<Integer> resultPositions = lookupMap.get(input[i]);
                for(int j: resultPositions) {
                    if(i != j && i<j) {
                        result.add(Arrays.asList(i,j));
                    }
                }
            }
        }
        return result.size();
    }
}
