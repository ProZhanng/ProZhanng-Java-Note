package com.learn.linkedlist;

public class BaseLinkedListTest {

    public ListNode initLinkedList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        return node1;
    }

    public void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.getVal() + "->");
            node = node.getNext();
        }
    }
}
