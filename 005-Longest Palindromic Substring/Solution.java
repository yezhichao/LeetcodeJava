package com.yzc;
// https://leetcode.com/problems/longest-palindromic-substring/discuss/133701/java-solution-using-dynamic-programming-with-a-clear-explaining
// https://zhuanlan.zhihu.com/p/25888881
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int beginIndex = 0, count = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                beginIndex = i;
                count = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    beginIndex = i;
                    count = len;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + count);

    }
}