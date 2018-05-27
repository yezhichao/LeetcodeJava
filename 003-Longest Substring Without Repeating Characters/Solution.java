package com.yzc;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        int max = 0; int pre = 0;
        int[] hash = new int[128];
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (hash[c] > pre) {
                pre = hash[c];
            }
            int l = i + 1 - pre;
            hash[c] = i + 1;
            if (l > max) max = l;
        }
        return max;
    }
}