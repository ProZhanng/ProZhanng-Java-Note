package com.learn.linkedlist;

import org.junit.Test;

public class DetectCycleReturnCycleNodeTest extends BaseLinkedListTest {

    public ListNode init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node2);
        return node1;
    }


    @Test
    public void detectCycleWithSlowAndFast() {
        ListNode head = init();
        DetectCycleReturnCycleNode function = new DetectCycleReturnCycleNode();
        ListNode listNode = function.detectCycleWithSlowAndFast(head);
        System.out.println(listNode);
    }
}
