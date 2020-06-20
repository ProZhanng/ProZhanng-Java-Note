package com.learn.linkedlist;

import lombok.Data;

/**
 * linked list node
 *
 * @author zhangneng
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
