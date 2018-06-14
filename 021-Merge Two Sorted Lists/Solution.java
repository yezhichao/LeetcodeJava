package com.yzc;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res;
        if (l1.val <= l2.val) {
            res = l1;
            l1 = l1.next;
        } else {
            res = l2;
            l2 = l2.next;
        }
        ListNode p = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) p.next = l2;
        if (l2 == null) p.next = l1;

        return res;
    }
}

// https://github.com/yezhichao/awesome-java-leetcode/blob/master/note/021/README.md
// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode head = new ListNode(0);
//         ListNode temp = head;
//         while (l1 != null && l2 != null) {
//             if (l1.val < l2.val) {
//                 temp.next = l1;
//                 l1 = l1.next;
//             } else {
//                 temp.next = l2;
//                 l2 = l2.next;
//             }
//             temp = temp.next;
//         }
//         temp.next = l1 != null ? l1 : l2;
//         return head.next;
//     }
// }