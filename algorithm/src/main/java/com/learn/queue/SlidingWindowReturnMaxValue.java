package com.learn.queue;

import org.junit.Test;

import java.util.*;

/**
 * @author zhangneng
 * Date: 2020/9/4
 */
public class SlidingWindowReturnMaxValue {

    /**
     * return the max value of the sliding window
     * <p>
     * 时间复杂度:logK*n
     *
     * @param nums array
     * @param k    sliding window size
     * @return
     */
    public int[] maxSlidingWindowSolutionOne(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() == k) {
                Integer maxVal = priorityQueue.peek();
                result.add(maxVal);
                priorityQueue.remove(nums[i - k]);
            }
            priorityQueue.add(nums[i]);
        }
        // 最后一次需要取值
        result.add(priorityQueue.peek());
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    /**
     * 暴力解法
     * <p></p>
     * 本质上与方法一类似，都是通过循环遍历每一个窗口，获取最大值，其中都要通过多次比较
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowSolutionTwo(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        // 一共有 n-k+1 个滑动窗口，这个是关键点
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                maxVal = Math.max(maxVal, nums[j]);
            }
            result[i] = maxVal;
        }
        return result;
    }

    /**
     * 双端队列实现最大值滑动窗口
     *
     * @return
     */
    public int[] maxSlidingWindowSolutionByDeQueue(int[] nums, int k) {
        ArrayDeque<Integer> dequeue = new ArrayDeque<>();
        int resultIndex = 0;
        int[] result = new int[nums.length - k + 1];
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < k; i++) {
            cleanQueue(dequeue, i, k, nums);
            dequeue.addLast(i);
        }
        result[resultIndex++] = nums[dequeue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            cleanQueue(dequeue, i, k, nums);
            dequeue.addLast(i);
            result[resultIndex++] = nums[dequeue.peekFirst()];
        }
        return result;
    }

    private void cleanQueue(Deque<Integer> deque, int index, int k, int[] nums) {
        if (!deque.isEmpty()) {
            deque.remove(index - k);
        }
        while (!deque.isEmpty() && nums[deque.getLast()] < nums[index]) {
            deque.removeLast();
        }
    }

    @Test
    public void funcTest() {
        int[] nums = new int[]{1, -1};
        int k = 1;
        int[] result = maxSlidingWindowSolutionByDeQueue(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
