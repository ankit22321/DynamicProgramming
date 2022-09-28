package com.practice.dynamicprogramming;

import java.util.Arrays;

public class CountTOReachPointAtoB {

    private static int recursiveWay(int x, int y, int m, int n){
        if(x == m-1 && y == n-1)
            return 1;
        if(x >= m || y >= n)
            return 0;
        return recursiveWay(x, y+1, m, n) + recursiveWay(x+1, y, m, n);
    }

    private static int dp(int x, int y, int m, int n) {
        long start = System.currentTimeMillis();
        int[][] arr = new int[m][n];

        arr[m-1][n-1] = 1;

        for (int i = m-1; i >= 0; i--){
            for (int j = n-1; j >= 0; j--){
                if (i == m-1 || j == n-1){
                    arr[i][j] = 1;
                    continue;
                }
                arr[i][j] = arr[i+1][j] + arr[i][j+1];
            }
        }
        System.out.println("time taken: "+(System.currentTimeMillis() - start));
        return arr[0][0];
    }

    public static void main(String[] args) {
        int x = 0, y = 0, m = 12, n = 14;

        long start = System.currentTimeMillis();
	    System.out.println(recursiveWay(x, y, m, n));
	    System.out.println("time taken: "+(System.currentTimeMillis() - start));

        System.out.println(dp(x, y, m, n));
    }


}
