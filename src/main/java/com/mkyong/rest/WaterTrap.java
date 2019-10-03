package com.mkyong.rest;

public class WaterTrap {
    public static void main(String[] args) {
        System.out.print(trap(new int[]{3, 0, 0, 8, 0, 9}));
    }

    public static int trap(int[] arr) {
        int result = 0;
        int n = arr.length;
        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            } else {
                if (arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
    }
}
