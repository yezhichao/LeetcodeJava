package com.yzc;

class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                sb.append(strs[i]);
                num=num-values[i];
            }
        }
         return sb.toString();   
        }
    }

//     class Solution {
//     public String intToRoman(int num) {
//         StringBuilder sb = new StringBuilder();
//         while (num > 0) {
//             if (num / 1000 > 0) {
//                 sb.append("M");
//                 num -= 1000;
//             } else if (num / 900 > 0) {
//                 sb.append("CM");
//                 num -= 900;
//             } else if (num / 500 > 0) {
//                 sb.append("D");
//                 num -= 500;
//             } else if (num / 400 > 0) {
//                 sb.append("CD");
//                 num -= 400;
//             } else if (num / 100 > 0) {
//                 sb.append("C");
//                 num -= 100;
//             } else if (num / 90 > 0) {
//                 sb.append("XC");
//                 num -= 90;
//             } else if (num / 50 > 0) {
//                 sb.append("L");
//                 num -= 50;
//             } else if (num / 40 > 0) {
//                 sb.append("XL");
//                 num -= 40;
//             } else if (num / 10 > 0) {
//                 sb.append("X");
//                 num -= 10;
//             } else if (num / 9 > 0) {
//                 sb.append("IX");
//                 num -= 9;
//             } else if (num/5 > 0) {
//                 sb.append("V");
//                 num -= 5;
//             } else if (num/4 > 0) {
//                 sb.append("IV");
//                 num -= 4;
//             } else if (num > 0) {
//                 sb.append("I");
//                 num--;
//             }
//         }
//         return sb.toString();
//     }
// }