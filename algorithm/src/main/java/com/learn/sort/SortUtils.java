package com.learn.sort;

import java.util.Arrays;

public class SortUtils {

    public static void swap(final int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void test(Sort sort) {
        boolean isOk = true;
        for (int i = 0; i < 100; i++) {
            int[] randomArray = generateRandomArray();
            int[] newArray = randomArray.clone();
            sort.sort(randomArray);
            Arrays.sort(newArray);
            if (!Arrays.equals(randomArray, newArray)) {
                System.out.println("Failure!");
                isOk = false;
                break;
            }
        }
        if (isOk) {
            System.out.println("OK!");
        }
    }


    private static int[] generateRandomArray() {
        int[] arr = new int[(int) ((50 + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((100 + 1) * Math.random()) - (int) (100 * Math.random());
        }
        return arr;
    }
}
