package com.yzc;

// https://github.com/yezhichao/awesome-java-leetcode/blob/master/note/024/README.md

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        preHead.next = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = temp.next;
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        return preHead.next;
    }
}

//class Solution {
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode node = head.next;
//        head.next = swapPairs(node.next);
//        node.next = head;
//        return node;
//    }
//}