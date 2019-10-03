package com.mkyong.rest;

import java.util.ArrayList;
import java.util.List;

public class Amazon {


    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
    // CLASS BEGINS, THIS CLASS IS REQUIRED
    int minimumDistance = Integer.MAX_VALUE;

    public static int[] maximize(int[] ar, int swapsAllowed) {
        int numSwaps = swapsAllowed;
        for (int j = 0; numSwaps != 0; j++) {
            int i = maxNum(ar, j, ar.length);
            if (numSwaps < ar.length - j)
                i = numSwaps;
            for (; i > 0; i--) {
                swap(ar, i, i - 1);
            }
        }
        return ar;
    }

    public static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static int maxNum(int ar[], int start, int end) {
        int max = ar[start];
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (max < ar[i]) {
                max = ar[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] a) {

//        0,0,0,5
//        0,1,1,5
//        0,1,0,0
//        1,0,0,0
        //int[][] inp = {{1, 0, 0}, {1, 0, 0}, {1, 9, 1}};
//        List a1 = new ArrayList();
//        a1.add(1);
//        a1.add(0);
//        a1.add(0);
//        List a2 = new ArrayList();
//        a2.add(1);
//        a2.add(0);
//        a2.add(0);
//        List a3 = new ArrayList();
//        a3.add(1);
//        a3.add(9);
//        a3.add(1);
//        List<List<Integer>> inp = new ArrayList();
//        inp.add(a1);
//        inp.add(a2);
//        inp.add(a3);

        // int result = new Amazon().minimumDistance(3, 3, inp);

        //System.out.print(result);
        int arr[] = {4, 5, 9};
        System.out.print(maximize(arr, 2));
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
        boolean[][] visited = new boolean[numRows][numColumns];
        visited[0][0] = true;
        movesUtil(numRows, numColumns, area, 0, 0, 0, visited);
        return minimumDistance;
        // WRITE YOUR CODE HERE
    }

    void movesUtil(int numRows, int numColumns, List<List<Integer>> area, int curX, int curY, int curSum, boolean[][] visited) {
        if (area.get(curX).get(curY) == 9) {
            minimumDistance = minimumDistance > curSum ? curSum : minimumDistance;
            return;
        }
        int[] x = new int[]{-1, 0, 0, 1};
        int[] y = new int[]{0, -1, 1, 0};
        for (int index = 0; index < 4; index++) {
            if (isRoad(area, numRows, numColumns, curX + x[index], curY + y[index])
                    &&
                    !visited[curX + x[index]][curY + y[index]]
            ) {
                visited[curX + x[index]][curY + y[index]] = true;
                movesUtil(numRows, numColumns, area, curX + x[index], curY + y[index], curSum + area.get(curX).get(curY), visited);
                visited[curX + x[index]][curY + y[index]] = false;
            }
        }
    }

    boolean isRoad(List<List<Integer>> area, int numRows, int numColumns, int x, int y) {
        return x < numRows && y < numColumns
                && x >= 0 && y >= 0
                && (area.get(x).get(y) == 1
                || area.get(x).get(y) == 9)
                ;
    }

    // METHOD SIGNATURE ENDS
}
