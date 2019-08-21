package com.learn.sort;

import org.junit.Test;

/**
 * 插入排序,时间复杂度O(n2)
 */
public class InsertSort implements Sort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 每次解决一个位置
        // 插入排序是由后往前冒泡的过程
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                SortUtils.swap(arr, j, j - 1);
            }
        }
    }

    @Test
    public void test() {
        SortUtils.test(new InsertSort());
    }
}
