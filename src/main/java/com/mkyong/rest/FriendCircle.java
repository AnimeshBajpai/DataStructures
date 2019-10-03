package com.mkyong.rest;

import java.util.HashSet;
import java.util.Set;

public class FriendCircle {
    Set a = new HashSet();

    public static void main(String[] args) {
        int[][] a = new int[3][3];
        a[0][0] = 1;
        a[0][1] = 1;
        a[0][2] = 0;
        a[1][0] = 1;
        a[1][1] = 1;
        a[1][2] = 0;
        a[2][0] = 0;
        a[2][1] = 0;
        a[2][2] = 1;


        System.out.print(new FriendCircle().findCircleNum(a));
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
//                a.add(i);
//                a.add(j);
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
//                System.out.print(a);
//                a = new HashSet();
                count++;
            }
        }
        return count;
    }
}
