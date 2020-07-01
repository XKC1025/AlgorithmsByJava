package com.xkc.datastruce.stack;

import lombok.Data;

/**
 * 数组模拟栈
 *
 * @author xukechen
 */
@Data
public class ArrayStackDemo {

    public static void main(String[] args) {

    }

}


class ArrayStack {

    /**
     * 栈的最大容量
     */
    private int maxSize;

    private int[] stack;

    /**
     * 栈顶
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top > -1 && top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("栈满！");
        } else {
            top++;
            stack[top] = val;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！");
        } else {
            int tmp = stack[top];
            top--;
            return tmp;
        }
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空！");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

}
