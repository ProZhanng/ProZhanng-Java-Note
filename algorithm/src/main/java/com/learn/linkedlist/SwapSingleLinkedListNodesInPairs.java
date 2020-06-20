package com.learn.linkedlist;

/**
 * swap nodes in pairs
 *
 * @author zhangneng
 */
public class SwapSingleLinkedListNodesInPairs {


    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * <p>
     * 交换链表相邻节点值
     *
     * @param head
     * @return
     */
    public ListNode swapPairsVal(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            if (next != null) {
                int tempVal = cur.val;
                cur.val = next.val;
                next.val = tempVal;
                cur = next.next;
            } else {
                // 链表节点为偶数时，cur指向最后一个节点，next为null
                break;
            }
        }
        return head;
    }

    /**
     * 交换链表相邻的两个节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairsNode(ListNode head) {
        ListNode dummy = new ListNode(-1);
        // 记录头节点
        dummy.next = head;
        ListNode prev = dummy;
        // head是迭代变量
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            // swap firstNode and secondNode
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            // Reinitializing
            prev = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
