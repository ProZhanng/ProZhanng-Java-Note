package com.learn.linkedlist;


import java.util.HashSet;

/**
 * detect linked list and return the first cycle node
 *
 * @author zhangneng
 */
public class DetectCycleReturnCycleNode {

    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    /**
     * time :O(n) space:O(1)
     * 对于链表，a 只无环节点数量（不包括环节点）， b 指带环节点数量
     * 题解：当快指针和慢指针相遇时，一定满足关系式 f = 2s,f = s+nb。当两指针相遇时，s=nb,此时在移动a距离即到达环开始位置。
     */
    public ListNode detectCycleWithSlowAndFast(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
