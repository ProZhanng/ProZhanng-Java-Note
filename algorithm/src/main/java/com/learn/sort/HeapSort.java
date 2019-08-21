package com.learn.sort;

import org.junit.Test;

/**
 * 堆排序.
 * 堆的性质。大根堆：根节点既大于左节点也大于右节点。大根堆的子堆也是大根堆
 * 堆的本质是一课完全二叉树，实际在存储时使用数组来存储
 * 对与某一个节点在数组中的位置i,其左节点为2i+1,右节点为2i+2,其父节点为(i-1)/2
 */
public class HeapSort implements Sort {

    /**
     * 整个排序过程分为两步，通过heapInsert构建堆
     * 通过heapify弹出一个数，并调整使剩余的数依然保持堆结构
     *
     * @param arr
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 构造大根堆结构
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 将最大的数交换到末尾，即解决了最后一个位置
        int lastIndex = arr.length - 1;
        SortUtils.swap(arr, 0, lastIndex);
        while (lastIndex > 0) {
            heapify(arr, 0, lastIndex);
            lastIndex--;
            SortUtils.swap(arr, 0, lastIndex);
        }
    }

    /**
     * 将下标为index的数插入到数组中构成堆.
     *
     * @param arr
     * @param index
     */
    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            SortUtils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * index所在的数变小后如何重新构建大根堆.
     *
     * @param arr
     * @param index
     * @param lastIndex 控制边界
     */
    public void heapify(int[] arr, int index, int lastIndex) {
        int left = 2 * index + 1;
        while (left < lastIndex) {
            int right = left + 1;
            int largest = right < lastIndex && arr[right] > arr[left] ? right : left;
            largest = arr[largest] > arr[index] ? largest : index;
            // 本身自己就是最大的
            if (largest == index) {
                break;
            }
            SortUtils.swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    @Test
    public void fun() {
        SortUtils.test(new HeapSort());
    }
}
