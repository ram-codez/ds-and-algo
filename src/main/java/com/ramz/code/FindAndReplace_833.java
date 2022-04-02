package com.ramz.code;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplace_833 {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        //Trick is to come up with frst pass and note down
        //"where to replace(indices)" and "what to replace(target index)"
        //We dont need sources because we use it to check match and
        //later iterate the main string based on index
        Map<Integer, Integer> table = new HashMap<>();
        for (int i=0; i<indices.length; i++) {
            // if a match is found in the original string, record it
            if (s.startsWith(sources[i], indices[i])) {
                table.put(indices[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< s.length(); ) {
            if (table.containsKey(i)) {
                // if a replacement was recorded before
                sb.append(targets[table.get(i)]);
                i+=sources[table.get(i)].length();
            } else {
                // if no replacement happened at this index
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "abcd";
        int[] indices = {0,2};
        String[] sources = {"a","cd"};
        String[] targets = {"eee","fff"};

        FindAndReplace_833 x = new FindAndReplace_833();

        System.out.println(x.findReplaceString(s, indices, sources, targets));
    }
}



