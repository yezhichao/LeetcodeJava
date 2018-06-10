package com.yzc;

// https://blog.csdn.net/baidu_23318869/article/details/72624966
// https://github.com/Blankj/awesome-java-leetcode/tree/master/note/017
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        String[] mappings = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<>(Arrays.asList(""));

        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '2';
            while (res.peek().length() == i) {
                String pop = res.pop();
                for (int j = 0; j < mappings[num].length(); j++) {
                    res.add(pop + mappings[num].charAt(j));
                }
            }
        }
        return res;
    }
}