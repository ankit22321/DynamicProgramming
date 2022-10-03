package com.practice.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TargetSum {

    private static int recursiveWay(int[] nums, int n, int sum){
        if(n == 0){
            return sum == 0 ? 1 : 0;
        }
        return recursiveWay(nums, n-1, sum-nums[n-1]) + recursiveWay(nums, n-1, sum+nums[n-1]);
    }

    private static int recursiveWayDP(int[] nums, int n, int sum, Map<Key, Integer> hash){
        Key key = new Key(n, sum);
        if(hash.containsKey(key)){
            return hash.get(key);
        }
        if(n == 0){
            if(sum == 0){
                hash.put(key, 1);
                return 1;
            }
            else {
                hash.put(key, 0);
                return 0;
            }
        }
        int count = recursiveWayDP(nums, n-1, sum-nums[n-1], hash) + recursiveWayDP(nums, n-1, sum+nums[n-1], hash);
        hash.put(key, count);
        return count;
    }

    private static int dp(int[] nums, int target){
        Map<Key, Integer> hash = new HashMap<>();
        return recursiveWayDP(nums, nums.length, target, hash);
    }

    static class Key{
        int index;
        int sum;
        public Key(int index, int sum){
            this.index = index;
            this.sum = sum;
        }
        @Override
        public boolean equals(Object obj){
            if (obj == null || obj.getClass() != this.getClass())
                return false;

            if (this == obj)
                return true;

            Key newKey = (Key) obj;
            if(this.index == newKey.index && this.sum == newKey.sum)
                return true;
            else
                return false;
        }
        @Override
        public int hashCode(){
            return Objects.hash(index, sum);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(recursiveWay(nums, nums.length, target));
        System.out.println(dp(nums, target));
    }
}
