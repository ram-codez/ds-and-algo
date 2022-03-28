package com.ramz.code;

import java.util.ArrayList;
import java.util.List;

public class MinTimeDiff_539 {

    public int findMinDifference(List<String> timePoints) {

        //Initialize 24*60 size boolean array to hold occurence of each minute. This is the main trick for O(n)
        boolean[] times = new boolean[24*60];

        for(String time : timePoints) {

            //Extract actual minute number
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));

            int timeNum = h * 60 + m;
            //If same time exists then return 0
            if(times[timeNum]) {
                return 0;
            }

            times[timeNum] = true;

        }

        //Optimize the complete array iteration by identifying minimum and max in the array
        int min, max, prev = 0;
        int result = Integer.MAX_VALUE;

        //To get min and max, we need index
        int index = 0;

        while (!times[index]) {
            index++;
        }
        min = index;

        //Reset index to last to get max
        index = times.length -1;
        while (!times[index]) {
            index--;
        }
        max = index;

        //Find the min looping from min to max
        prev = min;
        for(int i = min + 1; i <= max; i++){
            if(times[i]){
                result = Math.min(result, i - prev);
                prev = i;
            }
        }

        // since every two consectutive are compared, we also need to
        // compare the diff between first one and the last
        result = Math.min(result, (24 * 60 - max + min));
        return result;
    }

    public static void main(String[] args) {

        List<String> times = new ArrayList<>();
        times.add("23:59");
        times.add("00:00");
    }


}
