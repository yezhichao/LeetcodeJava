package com.yzc;

// https://segmentfault.com/a/1190000009583575
class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (pLen == 0) {
            return sLen == 0;
        }
        if (pLen == 1) {
            return sLen == 1 && (getChar(s, 0) == getChar(p, 0) || getChar(p, 0) == '.');
        }

        if (getChar(p, 1) != '*') {
            if (sLen == 0) {
                return false;
            } else {
                return (getChar(s, 0) == getChar(p, 0) || getChar(p, 0) == '.') &&
                        isMatch(s.substring(1), p.substring(1));
            }
        } else {
            while (s.length() > 0 && (getChar(s, 0) == getChar(p, 0) || getChar(p, 0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }

    public char getChar(String str, int position) {
        if (position < str.length()) {
            return str.charAt(position);
        } else {
            return 0;
        }
    }
}