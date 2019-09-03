package com.learn.sort;

import org.junit.Test;

public class MergeSort implements Sort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] sortedArr = MergeSort(arr, 0, arr.length - 1);
        System.arraycopy(sortedArr, 0, arr, 0, sortedArr.length);
    }

    /**
     * 归并排序，先进行左右拆分，然后在合并，返回新的数组.
     */
    public int[] MergeSort(final int[] arr, int left, int right) {
        // 定义递归条件的出口
        if (left == right) {
            return new int[]{arr[left]};
        }
        // 进行递归，拆分问题的规模
        int middle = (left + right) / 2;
        int[] leftArr = MergeSort(arr, left, middle);
        int[] rightArr = MergeSort(arr, middle + 1, right);
        return merge(leftArr, rightArr);
    }

    public int[] merge(final int[] leftArr, int[] rightArr) {
        int length = leftArr.length + rightArr.length;
        int[] newArr = new int[length];
        int leftIndex = 0;
        int rightIndex = 0;
        int i = 0;
        while (leftIndex <= leftArr.length - 1 && rightIndex <= rightArr.length - 1) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                newArr[i] = leftArr[leftIndex];
                i++;
                leftIndex++;
            } else if (leftArr[leftIndex] == rightArr[rightIndex]) {
                newArr[i] = leftArr[leftIndex];
                i++;
                leftIndex++;
                newArr[i] = rightArr[rightIndex];
                i++;
                rightIndex++;
            } else if (leftArr[leftIndex] > rightArr[rightIndex]) {
                newArr[i] = rightArr[rightIndex];
                i++;
                rightIndex++;
            }
        }
        while (leftIndex <= leftArr.length - 1) {
            newArr[i] = leftArr[leftIndex];
            i++;
            leftIndex++;
        }
        while (rightIndex <= rightArr.length - 1) {
            newArr[i] = rightArr[rightIndex];
            i++;
            rightIndex++;
        }
        return newArr;
    }

    @Test
    public void fun() {
        SortUtils.test(new MergeSort());
    }
}
