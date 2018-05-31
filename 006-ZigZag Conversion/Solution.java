package com.yzc;
// http://www.cnblogs.com/TenosDoIt/p/3738693.html
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int interval = (numRows << 1) - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i += interval) {
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i++) {
            int midInterval = i << 1;
            for (int j = i; j < len; j += midInterval) {
                sb.append(s.charAt(j));
                midInterval = interval - midInterval;
            }
        }
        for (int i = numRows - 1; i < len; i += interval) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}