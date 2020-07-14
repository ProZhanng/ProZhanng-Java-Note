package com.learn.linkedlist;

import org.junit.Test;

/**
 * @author: zhangneng
 * @date: 2020-07-06 20:02
 **/
public class ReverseListInkGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        // 额外增加结点，指向头指针
        ListNode hair = new ListNode(-1);
        hair.next = head;
        // 用于循环的变量
        ListNode prev = hair;
        ListNode tail = hair;
        while (head != null) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nextListHead = tail.next;
            ListNode[] reverseNodes = reverse(head, tail);
            // 与上下游链表相接
            reverseNodes[1].next = nextListHead;
            prev.next = reverseNodes[0];
            // 利用返回的reverse数组重新给prev tail head重新初始化变量
            prev = reverseNodes[1];
            tail = reverseNodes[1];
            head = nextListHead;
        }
        return hair.next;
    }

    /**
     * 临界条件是prev不等于tail结点
     *
     * @param head
     * @param tail
     * @return
     */
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }

    @Test
    public void test() {
        ListNode head = init();
        printList(head);
        System.out.println();
        ListNode result = reverseKGroup(head, 2);
        printList(result);
    }

    public ListNode init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    public void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }
}

