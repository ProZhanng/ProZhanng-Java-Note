package com.learn.map;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 *
 * @author zhangneng
 * Date: 2021/1/21
 */
public class TwoSum {

    public int[] twoSum_1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 在 HashMap 中求值可以达到时间复杂度为O(1)
    public int[] twoSum_2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            integerHashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            final int otherNum = target - nums[i];
            // 可能出现包含自身的情况，加条件 integerHashMap.get(otherNum) != i
            if (integerHashMap.containsKey(otherNum)
                    && integerHashMap.get(otherNum) != i) {
                return new int[]{i, integerHashMap.get(otherNum)};
            }
        }
        return null;

    }

    public int[] twoSum_3(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        final HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerHashMap.containsKey(target - nums[i])) {
                return new int[]{integerHashMap.get(target - nums[i]), i};
            } else {
                integerHashMap.put(nums[i], i);
            }
        }
        return null;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        final int[] result = twoSum_2(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
