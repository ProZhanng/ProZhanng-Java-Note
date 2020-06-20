package com.learn.linkedlist;

import org.junit.Test;

public class ReverseSingleLinkedListTest extends BaseLinkedListTest {

    @Test
    public void reverseList() {
        ListNode head = initLinkedList();
        // 原始
        printLinkedList(head);
        ReverseSingleLinkedList function = new ReverseSingleLinkedList();
        ListNode reverseNode = function.reverseList(head);
        System.out.println();
        printLinkedList(reverseNode);
    }
}