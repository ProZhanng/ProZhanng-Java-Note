package com.learn.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * implement stack of FILO using queue
 *
 * @author zhangneng
 */
public class QueueImplUsingTwoStack {

    private Stack<Integer> inputStack;

    private Stack<Integer> outputStack;

    /**
     * Initialize your data structure here.
     */
    public QueueImplUsingTwoStack() {
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inputStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        if (outputStack.isEmpty()) {
            throw new RuntimeException("队列中没有元素");
        }
        return outputStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        // 只有输出队列为空时才能导入数据
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        if (outputStack.isEmpty()) {
            throw new RuntimeException("队列中没有元素");
        }
        return outputStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    @Test
    public void test() {
        QueueImplUsingTwoStack stack = new QueueImplUsingTwoStack();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        int int1 = stack.pop();
        System.out.println(int1);
        int int2 = stack.peek();
        System.out.println(int2);
        int int3 = stack.pop();
        System.out.println(int3);
        int int4 = stack.pop();
        System.out.println(int4);
        boolean empty = stack.empty();
        System.out.println(empty);
    }
}
