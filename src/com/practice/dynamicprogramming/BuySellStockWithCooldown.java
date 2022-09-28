package com.practice.dynamicprogramming;

public class BuySellStockWithCooldown {

    private static int recursiveWay(int[] prices, int profit, int i, boolean stockPresent){
        if (i >= prices.length)
            return profit;
        if (stockPresent)
            return Integer.max(recursiveWay(prices, profit-prices[i], i+2, false), recursiveWay(prices, profit, i+1, true));
        else
            return Integer.max(recursiveWay(prices, profit+prices[i], i+1, true), recursiveWay(prices, profit, i+1, false));
    }

    private static int dp(int[] prices){
        int n = prices.length;

        int[][] arr = new int[n+2][2];

        for (int i = n+1; i >= 0; i--){
            for (int j = 1; j >= 0; j--){
                if (i >= n){
                    arr[i][j] = 0;
                    continue;
                }
                if(j == 0)
                    arr[i][j] = Integer.max(arr[i+1][1] - prices[i], arr[i+1][0]);
                else
                    arr[i][j] = Integer.max(prices[i] + arr[i+2][0], arr[i+1][1]);
            }
        }
        return arr[0][0];
    }

    public static void main(String[] args){
        int[] prices = new int[]{1, 2, 3, 0, 2};

        System.out.println(recursiveWay(prices, 0, 0, false));
        System.out.println(dp(prices));
    }
}
