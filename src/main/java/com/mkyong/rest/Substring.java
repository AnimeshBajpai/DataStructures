package com.mkyong.rest;

import java.util.HashMap;
import java.util.Map;

public class Substring {
    public static void main(String ar[]) {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        int n = 15;
//        for (int L = 1; L * (L + 1) < 2 * N; L++) {
//            float a = (float) ((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
//            if (a - (int) a == 0.0)
//                count++;
//        }
        int i = 1, j = 1, sum = 1;
        while (j < n) {
            if (sum == n) { // matched, move sub-array section forward by 1
                count++;
                sum -= i;
                i++;
                j++;
                sum += j;
            } else if (sum < n) { // not matched yet, extend sub-array at end
                j++;
                sum += j;
            } else { // exceeded, reduce sub-array at start
                sum -= i;
                i++;
            }
        }
        System.out.print(count);
    }

    // your code goes here
    // your code goes here
    public void sub() {
        String s = "abcde";
        Map<String, Integer> substrings = new HashMap();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i);

            for (int j = 0; j < sub.length(); j++) {
                String subDistinct = sub.substring(0, sub.length() - j);

                if (!substrings.containsKey(subDistinct)) {
                    substrings.put(subDistinct, 1);
//                    Console.WriteLine(subDistinct);
                    count += 1;
                } else {
                    continue;
                }
            }
        }
        System.out.print(count);
    }
}