package com.learn.stack;


import org.junit.Test;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * valid the parentheses
 *
 * @author zhangneng
 */
public class ValidParentheses {

    /**
     * stack 先进县出的结构适合对称的题解
     *
     * @param str
     * @return
     */
    public boolean isValidOne(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popCh = stack.pop();
                boolean matchCase1 = ch == ')' && popCh == '(';
                boolean matchCase2 = ch == ']' && popCh == '[';
                boolean matchCase3 = ch == '}' && popCh == '{';
                if (!(matchCase1 || matchCase2 || matchCase3)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidTwo(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Set<Character> rightCharSet = map.keySet();
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!rightCharSet.contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pop().equals(map.get(ch))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testFunc() {
        String str1 = "()[]{}";
        System.out.println(isValidTwo(str1));

    }
}
