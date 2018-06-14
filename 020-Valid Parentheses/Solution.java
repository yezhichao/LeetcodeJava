package com.yzc;

// https://github.com/yezhichao/awesome-java-leetcode/blob/master/note/020/README.md
class Solution {
    public boolean isValid(String s) {
        Stack<CharSequence> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c + "");
            } else if (c == ')') {
                if (stack.empty() || !stack.pop().equals("(")) return false;
            } else if (c == '}') {
                if (stack.empty() || !stack.pop().equals("{")) return false;
            } else if (c == ']') {
                if (stack.empty() || !stack.pop().equals("[")) return false;
            }
        }
        return stack.empty();
    }
}

// see detail
// class Solution {
//    public boolean isValid(String s) {
//        char[] stack = new char[s.length() + 1];
//        int top = 1;
//        for (char c : s.toCharArray()) {
//            if (c == '(' || c == '{' || c == '[') {
//                stack[top++] = c;
//            } else if (c == ')' && stack[--top] != '(') {
//                return false;
//            }  else if (c == '}' && stack[--top] != '{') {
//                return false;
//            }  else if (c == ']' && stack[--top] != '[') {
//                return false;
//            }
//        }
//        return top == 1;
//    }
// }