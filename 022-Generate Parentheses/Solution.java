package com.yzc;

// https://github.com/yezhichao/awesome-java-leetcode/blob/master/note/022/README.md

//class Solution {
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//        helper(res, "", 0, n);
//        return res;
//    }
//
//    private void helper(List<String> list, String s, int rightNeed, int leftRest) {
//        if (rightNeed == 0 && leftRest ==0 ) {
//            list.add(s);
//            return;
//        }
//        if (leftRest != 0) helper(list, s + "(", rightNeed + 1, leftRest - 1);
//        if (rightNeed != 0) helper(list, s + ")", rightNeed - 1, leftRest);
//    }
//}

class Solution {
    public List<String> generateParenthesis(int n) {
        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        hashMap.put(0, Collections.singletonList(""));
        for (int i = 1; i <= n ; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String fj: hashMap.get(j)) {
                    for (String fi_j_1: hashMap.get(i-j-1)) {
                        list.add("(" + fj + ")" + fi_j_1);
                    }
                }
            }
            hashMap.put(i, list);
        }
        return hashMap.get(n);
    }
}