package com.practice.dynamicprogramming;

public class CoinChange2 {
    /**
     * Either use last coin or not use the last coin and recompute the subtracted amount
     */
    private static int recursiveWay(int[] coins, int n, int sum){
        if(sum == 0)
            return 1;

        if(sum < 0 || n <= 0)
            return 0;

        return recursiveWay(coins, n, sum-coins[n-1]) + recursiveWay(coins, n-1, sum);
    }

    private static int dp(int[] coins, int amount){
        int[][] arr = new int[coins.length+1][amount+1];
        for (int i = 0; i <= coins.length; i++){
            for (int j = 0; j <= amount; j++){
                if (i == 0){
                    arr[i][j] = 0;
                    continue;
                }
                if(j == 0){
                    arr[i][j] = 1;
                    continue;
                }
                arr[i][j] = ((j-coins[i-1]) >= 0 ? arr[i][j-coins[i-1]] : 0) + arr[i-1][j];
            }
        }
        return arr[coins.length][amount];
    }

    public static void main(String[] args){
        int[] coins = new int[]{1,2,5};
        int sum = 5;

        System.out.println(recursiveWay(coins, coins.length, sum));
        System.out.println(dp(coins, sum));
    }
}
