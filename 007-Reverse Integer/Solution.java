package com.yzc;
// https://www.jianshu.com/p/6030916240fb
// http://fisherlei.blogspot.com/2012/12/leetcode-reverse-integer.html
class Solution {
    public int reverse(int x) {
        long newInt = 0;
        int tmp = Math.abs(x);
        int left = 0;
        while (tmp > 0) {
            left = tmp % 10;
            newInt = newInt * 10 + left;
            if (newInt > Integer.MAX_VALUE) return 0;
            tmp = tmp / 10;
        }
        return (int)(x > 0? newInt: -newInt);
    }
}