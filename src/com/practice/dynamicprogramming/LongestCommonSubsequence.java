package com.practice.dynamicprogramming;

public class LongestCommonSubsequence {

    static int recursiveWay(String text1, String text2){
        if(text1.length() == 0 || text2.length() == 0)
            return 0;
        char a = text1.charAt(0);
        char b = text2.charAt(0);
        int max = Integer.max(recursiveWay(text1, text2.substring(1)), recursiveWay(text1.substring(1), text2));
        if(a == b){
            max = Integer.max(max, 1+recursiveWay(text1.substring(1), text2.substring(1)));
        }
        return max;
    }

    static int dp(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        int[][] arr = new int[m+1][n+1];

        for (int i = m; i >= 0; i--){
            for (int j = n; j >= 0; j--){
                if (i == m || j == n){
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = Integer.max(arr[i+1][j], arr[i][j+1]);
                if(text1.charAt(i) == text2.charAt(j))
                    arr[i][j] = Integer.max(arr[i][j], 1+arr[i+1][j+1]);
            }
        }

        return arr[0][0];
    }

    public static void main(String[] args){
        String s1 = "abcde";
        String s2 = "abcde";

        System.out.println(recursiveWay(s1, s2));
        System.out.println(dp(s1, s2));
    }
}
