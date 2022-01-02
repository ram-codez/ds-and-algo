package com.ramz.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] input = {1,2,3,5,4,7,8,6,9};
        //int[] input = {1,2};
        //int[] input = {1};
        //int[] input = {};
        System.out.println(getThreeSum(input, 9));
    }

    public static List<List<Integer>> getThreeSum(int[] input, int target) {

        Arrays.sort(input);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < input.length-2; i++) {

            //Trick is to figure out duplicate elements in input.
            //Once we find the combination, we move forward when there are duplicates and also in the first loop
            //we continue only when previous element is different from current element because we already went to
            //the last occurrence in inner check, so we keep both in sync
            if(i==0 || (i!=0 && input[i] != input[i-1])) {

                int j=i+1;
                int k=input.length-1;

                while(j < k) {
                    if(input[i] + input[j] + input[k] <  target) {
                        j++;
                    } else if(input[i] + input[j] + input[k] >  target) {
                        k--;
                    } else {
                        result.add(Arrays.asList(input[i], input[j], input[k]));
                        while(j<k && input[j] == input[j+1]) j++;
                        while(j<k && input[k] == input[k-1]) k--;
                        j++;
                        k--;
                    }
                }
            }
        }

        return result;
    }

}
