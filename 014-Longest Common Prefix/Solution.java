package com.yzc;

// see detail
// also https://blog.csdn.net/MebiuW/article/details/50909486
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
// class Solution {
//     public static String longestCommonPrefix(String[] strs) {
//         int sLen = strs.length;
//         if (sLen == 0) return "";
//         int minLen = strs[0].length();
//         for (int i = 0; i < sLen; i++) {
//             if (strs[i].length() < minLen) {
//                 minLen = strs[i].length();
//             }
//         }

//         for (int i = 0; i < minLen; i++) {
//             for (int j = 1; j < sLen; j++) {
//                 if (strs[j].charAt(i) != strs[0].charAt(i)) {
//                     return strs[0].substring(0, i);
//                 }
//             }
//         }

//         return strs[0].substring(0, minLen);
//     }
// }