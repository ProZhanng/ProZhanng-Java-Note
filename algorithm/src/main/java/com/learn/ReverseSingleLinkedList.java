package com.learn;

import lombok.Data;
import org.junit.Test;

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
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

@Data
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
