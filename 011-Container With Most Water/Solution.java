package com.yzc;

// https://hk029.gitbooks.io/leetbook/%E6%95%B0%E7%BB%84/011.%20Container%20With%20Most%20Water[M].html
class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int volMax = 0;
        while (l < r) {
            int vol = Math.min(height[l], height[r]) * (r - l);
            if (vol > volMax) volMax = vol;

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return volMax;
    }
}