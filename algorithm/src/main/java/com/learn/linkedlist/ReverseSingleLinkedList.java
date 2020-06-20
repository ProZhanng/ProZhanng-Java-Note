package com.learn.linkedlist;

/**
 * reverse single linked list
 *
 * @author zhangneng
 */
public class ReverseSingleLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

