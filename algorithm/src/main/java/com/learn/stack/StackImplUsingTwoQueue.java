package com.learn.stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * implement queue of FIFO using stack
 *
 * @author zhangneng
 */
public class StackImplUsingTwoQueue {

    private Queue<Integer> inputQueue;
    private Queue<Integer> outputQueue;

    /**
     * Initialize your data structure here.
     */
    public StackImplUsingTwoQueue() {
        inputQueue = new LinkedList<>();
        outputQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        this.inputQueue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (inputQueue.size() > 1) {
            outputQueue.offer(inputQueue.poll());
        }
        Integer result = inputQueue.poll();
        Queue<Integer> temp;
        temp = inputQueue;
        inputQueue = outputQueue;
        outputQueue = temp;
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (inputQueue.size() > 1) {
            outputQueue.offer(inputQueue.poll());
        }
        Integer result = inputQueue.peek();
        outputQueue.offer(inputQueue.poll());
        Queue<Integer> temp;
        temp = inputQueue;
        inputQueue = outputQueue;
        outputQueue = temp;
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return inputQueue.isEmpty();
    }

    @Test
    public void testFun() {
        StackImplUsingTwoQueue stack = new StackImplUsingTwoQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

}
