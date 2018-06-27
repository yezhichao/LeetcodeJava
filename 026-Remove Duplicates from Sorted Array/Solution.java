package com.yzc;

// https://github.com/yezhichao/awesome-java-leetcode/blob/master/note/026/README.md

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int tail = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i-1]) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }
}