package com.mkyong.rest;

public class Sub {
    int count = 0;

    void printSubSeqRec(String str, int n,
                        int index, String curr) {
        // base case
        if (index == n) {
            return;
        }
        count++;
        //System.out.println(curr);
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            printSubSeqRec(str, n, i, curr);

            // backtracking
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    // Generates power set in
    // lexicographic order.
    void printSubSeq(String str) {
        int index = -1;
        String curr = "";

        printSubSeqRec(str, str.length(), index, curr);
    }

    // Driver code
    public static void main(String[] args) {
        String str = "";//
//        Sub s = new Sub();
//                s.printSubSeq(str);
        System.out.println(consecutive(15));
    }

    public static int consecutive(long num) {
        // Write your code here
        int result = 0;
        for (int i = 1; i <= (int) Math.sqrt(2 * num); i++) {
            if ((2 * num % i) != 0) continue;
            long x = 2 * (num / i) - i - 1;
            if (x % 2 == 0 && x >= 0) {
                result++;
            }
        }
        return result - 1;
    }

}
