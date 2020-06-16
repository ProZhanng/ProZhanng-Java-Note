package com.learn;

import org.junit.Test;

public class ReverseSingleLinkedListTest {

    @Test
    public void reverseList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // 原始
        printLinkedList(node1);
        ReverseSingleLinkedList function = new ReverseSingleLinkedList();
        ListNode reverseNode = function.reverseList(node1);
        System.out.println();
        printLinkedList(reverseNode);
    }

    private void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.getVal() + "->");
            node = node.next;
        }
    }
}