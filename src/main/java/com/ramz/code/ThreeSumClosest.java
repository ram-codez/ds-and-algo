package com.ramz.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public static void main(String[] args) {

        int[] input = {-1,2,1,-4};
        //int[] input = {1,2};
        //int[] input = {1};
        //int[] input = {};
        System.out.println(print3SumClosest(input, 1));
    }

    public static int print3SumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;;

        for(int i = 0; i < nums.length-2; i++) {

            int j=i+1;
            int k=nums.length-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                //Here we do sum for every combination and update the closest. In 3 sum, we move and only get sum after both comparision fail

                if(sum == target) return sum;

                if(sum <  target) {
                    j++;
                } else if(sum >  target) {
                    k--;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                     result = sum;
                }
            }
        }
        return result;
    }

}
