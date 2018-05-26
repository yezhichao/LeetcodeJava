package com.yzc;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int a = l1 != null? l1.val: 0;
            int b = l2 != null? l2.val: 0;
            
            int sum = a + b + carry;
            int nodeDigit = sum%10;
            carry = sum/10;
            
            cur.next = new ListNode(nodeDigit);
            cur = cur.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return res.next;
    }
}
