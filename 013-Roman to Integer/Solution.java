package com.yzc;

// see deatils
class Solution {
    int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(i != s.length() - 1 && getValue(ch) < getValue(s.charAt(i + 1))) {
                sum -= getValue(ch);
            }else {
                sum += getValue(ch);
            }
        }
        return sum;
    }
}

// class Solution {
//     HashMap<String, Integer> map = new HashMap<String, Integer>() {
//         {
//             put("M", 1000);
//             put("CM", 900);
//             put("D", 500);
//             put("CD", 400);
//             put("C", 100);
//             put("XC", 90);
//             put("L", 50);
//             put("XL", 40);
//             put("X", 10);
//             put("IX", 9);
//             put("V", 5);
//             put("IV", 4);
//             put("I", 1);
//         }
//     };
//     public int romanToInt(String s) {
//         int len = s.length();
//         int res = 0;
//         for (int i = 0; i < len; ) {
//             char c = getChar(s, i);
//             if (c == 'C' || c == 'X' || c == 'I') {
//                 StringBuilder sb = new StringBuilder();
//                 String str = sb.append(c).append(getChar(s, i + 1)).toString();
//                 if (map.containsKey(str)) {
//                     res += map.get(str);
//                     i += 2;
//                 } else {
//                     res += map.get(getChar(s, i)+"");
//                     i++;
//                 }
//             } else {
//                 res += map.get(getChar(s, i)+"");
//                 i++;
//             }
//         }
//         return res;
//     }

//     public char getChar(String s, int index) {
//         if (index < s.length()) return s.charAt(index);
//         else return 0;
//     }
}