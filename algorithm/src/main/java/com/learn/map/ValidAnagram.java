package com.learn.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * valid anagram 字母异位词
 *
 * @author zhangneng
 * Date: 2020/12/28
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "cbad"));
    }

    /**
     * 两种解法。
     * 1. 排序比较
     * 2. 通过map比较 O(n)
     * 3. 如果字母都是小写字母，维护一个hash表。s.charAt(i) - 'a'
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sCharMap = new HashMap<>();
        HashMap<Character, Integer> tCharMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            Integer count = sCharMap.getOrDefault(ch, 0);
            sCharMap.put(ch, ++count);
        }
        for (Character ch : t.toCharArray()) {
            Integer count = tCharMap.getOrDefault(ch, 0);
            tCharMap.put(ch, ++count);
        }
        // 比较两个map是否相等
        boolean result = true;
        for (Map.Entry<Character, Integer> entry : sCharMap.entrySet()) {
            Integer tCount = tCharMap.get(entry.getKey());
            if (Objects.isNull(tCount) || !tCount.equals(entry.getValue())) {
                result = false;
                break;
            }
        }
        for (Map.Entry<Character, Integer> entry : tCharMap.entrySet()) {
            Integer sCount = sCharMap.get(entry.getKey());
            if (Objects.isNull(sCount) || !sCount.equals(entry.getValue())) {
                result = false;
                break;
            }
        }
        return result;
    }
}
