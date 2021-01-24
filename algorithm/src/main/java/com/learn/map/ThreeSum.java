package com.learn.map;

import org.junit.Test;

import java.util.*;

/**
 * 三数之和
 *
 * @author zhangneng
 * Date: 2021/1/21
 */
public class ThreeSum {

    /**
     * O(n3)的时间复杂度
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        // 先排序，去重
        Arrays.sort(nums);
        HashMap<List<Integer>, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        resultMap.put(Arrays.asList(nums[i], nums[j], nums[k]), null);
                    }
                }
            }
        }
        return new ArrayList<>(resultMap.keySet());
    }

    public List<List<Integer>> threeSum_2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        HashMap<List<Integer>, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            // 可能存在重复元素
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(-(nums[i] + nums[j]))) {
                    resultMap.put(Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j])), null);
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(resultMap.keySet());
    }

    public List<List<Integer>> threeSum_3(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (!hashMap.containsKey(nums[j])) {
                    hashMap.put(-nums[i] - nums[j], 0);
                } else if (hashMap.get(nums[j]) == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
                    // 放入任意一个非0的数字，表示该数字已经有结果
                    hashMap.put(nums[j], 1);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-2, 0, 1, 1, 2};
        final List<List<Integer>> result = threeSum_2(nums);
        result.forEach(l -> {
            System.out.println(Arrays.toString(l.toArray(new Integer[l.size()])));
        });
    }
}
