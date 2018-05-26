package com.yzc;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1) return null;
        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
