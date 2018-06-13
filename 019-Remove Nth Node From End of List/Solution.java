package com.yzc;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/019/README.md

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (n-- != 0 && fast != null) {
            fast = fast.next;
        }
        if (fast != null) {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        } else {
            head = head.next;
        }
        return head;
    }
}