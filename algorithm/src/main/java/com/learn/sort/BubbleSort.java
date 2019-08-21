package com.learn.sort;

import org.junit.Test;

/**
 * 冒泡排序,时间复杂度O(n2).
 */
public class BubbleSort implements Sort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    @Test
    public void test() {
        SortUtils.test(new BubbleSort());
    }

}
