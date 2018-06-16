package com.yzc;

// https://github.com/yezhichao/awesome-java-leetcode/blob/master/note/023/README.md

//class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) return null;
//        return helper(lists, 0, lists.length - 1);
//    }
//
//    private ListNode helper(ListNode[] lists, int l, int r) {
//        if (l == r) return lists[l];
//        int mid = (l + r) >> 1;
//        ListNode l0 = helper(lists, l, mid);
//        ListNode l1 = helper(lists, mid + 1, r);
//        return mergeTwoList(l0,l1);
//    }
//
//    private ListNode mergeTwoList(ListNode l0, ListNode l1) {
//        ListNode head = new ListNode(0), temp = head;
//        while (l0 != null && l1 != null) {
//            if (l0.val < l1.val) {
//                temp.next = l0;
//                l0 = l0.next;
//            } else {
//                temp.next = l1;
//                l1 = l1.next;
//            }
//            temp = temp.next;
//        }
//        temp.next = l0 == null? l1: l0;
//        return head.next;
//    }
//}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node: lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        ListNode res = new ListNode(0), temp = res;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            // 把原先节点的next指针置空，防止在输出之后迭代的时候成环，从而死循环
            node.next = null;
            temp.next = node;
            temp = temp.next;
        }

        return res.next;
    }
}