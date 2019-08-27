package com.learn.sort;

import org.junit.Test;

/**
 * 快排，基于递归.
 */
public class QuickSort implements Sort {


    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }


    private void quickSort(final int[] arr, int left, int right) {
        if (left < right) {
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }
    }

    /**
     * 选择数组的最后一个数字，保证小于区域在左边，大于区域在右边，等于区域在中间.
     */
    private int[] partition(final int[] arr, int left, int right) {
        // less 指向小于区域的下标边界
        // more 指向大于区域的小标边界
        int less = left - 1;
        int more = right;
        // 以left作为指针来移动
        while (left < more) {
            if (arr[left] < arr[right]) {
                less++;
                SortUtils.swap(arr, less, left);
                left++;
            } else if (arr[left] == arr[right]) {
                left++;
            } else if (arr[left] > arr[right]) {
                more--;
                SortUtils.swap(arr, left, more);
            }
        }
        SortUtils.swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    @Test
    public void fun() {
        SortUtils.test(new QuickSort());
    }
}
