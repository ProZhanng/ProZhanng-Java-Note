package com.learn.linkedlist;

import lombok.Data;

import java.util.HashSet;

/**
 * detect single linked list cycle
 *
 * @author zhangneng
 */
@Data
public class DetectCycle {


    /**
     * using set save the node
     *
     * @param head
     * @return
     */
    public boolean hasCycleWithSet(ListNode head) {
        HashSet<ListNode> nodeSet = new HashSet<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            if (nodeSet.contains(cur)) {
                return true;
            }
            nodeSet.add(cur);
            cur = cur.next;
        }
        return false;
    }

    /**
     * using slow node and fast node
     *
     * @param head
     * @return
     */
    public boolean hasCycleWithSlowAndFast(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
