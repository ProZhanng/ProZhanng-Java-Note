package com.learn.queue;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * return the k largest value
 *
 * @author zhangneng
 */
public class KthLargest {

    private PriorityQueue<Integer> queue;
    private Integer k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // 临界条件是小于
        if (queue.size() < k) {
            queue.offer(val);
        } else {
            // 插入的值比最小堆元素小则插入数据
            if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }

}
