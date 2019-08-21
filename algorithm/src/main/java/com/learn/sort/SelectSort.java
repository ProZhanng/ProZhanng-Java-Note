package com.learn.sort;

import org.junit.Test;

/**
 * 选择排序，时间复杂度O(n2)
 */
public class SelectSort implements Sort {


    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 每次选择最大的数据交换到最后
        for (int i = arr.length - 1; i > 0; i--) {
            int maxValIndex = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[maxValIndex]) {
                    maxValIndex = j;
                }
            }
            SortUtils.swap(arr, i, maxValIndex);
        }
    }

    @Test
    public void test() {
        SortUtils.test(new SelectSort());
    }
}
