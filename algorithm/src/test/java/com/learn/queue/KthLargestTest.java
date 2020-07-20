package com.learn.queue;

import org.junit.Test;

public class KthLargestTest {

    @Test
    public void fun() {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        int result = kthLargest.add(3);
        System.out.println(result);
    }
}
