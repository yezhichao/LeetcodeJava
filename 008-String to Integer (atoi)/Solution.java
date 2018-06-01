package com.yzc;

class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        long res = 0;
        boolean begin = false;
        boolean nagetive = false;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (!begin) {
                if (c == ' ') continue;

                if (!Character.isDigit(c)) {
                    if (c == '-') {
                        nagetive = true;
                        begin = true;
                    } else if (c == '+') {
                        nagetive = false;
                        begin = true;
                    } else {
                        return 0;
                    }
                } else {
                    // 第一个字符是数字
                    begin = true;
                    int d = c - '0';
                    res = d;
                }
            } else {
                if (!Character.isDigit(c)) {
                    return nagetive? -(int)res: (int)res;
                } else {
                    res = res * 10 + (c - '0');
                    if (res > Integer.MAX_VALUE) return nagetive? Integer.MIN_VALUE: Integer.MAX_VALUE;
                }
            }
        }
        return nagetive? -(int)res: (int)res;
    }
}