package com.yzc;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int pal = 0;
        int temp = x;
        while (temp > 0) {
            int d = temp % 10;
            pal = pal * 10 + d;
            temp /= 10;
        }
        return pal == x;
    }
}