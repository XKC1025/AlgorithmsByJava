package com.xkc.datastruce.queue;

/**
 * 循环队列
 *
 * @author xukechen
 */
public class CircularQueueDemo {
}

class CircularQueue {

    /**
     * 队列最大容量
     */
    private int maxSize;

    /**
     * 指向队列的第一个元素, arr[front]就是队列的第一个元素
     * 初始值为0
     */
    private int front;

    /**
     * 指向队列的最后一个元素的下一个位置, 空出一个空间作为约定
     * 初始值为0
     */
    private int rear;

    /**
     * 队列具体容器
     */
    private int[] arr;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    /**
     * 满：(rear + 1) % maxSize == front
     *
     * @return
     */
    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    /**
     * 空：this.rear == this.front;
     *
     * @return
     */
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    /**
     * 有效数据个数： (rear + maxSize - front) % maxSize
     */
    public int validNumbers() {
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }

    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        this.arr[this.rear++] = n;
        this.rear = this.rear % this.maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int n = this.arr[this.front++];
        this.front = this.front % this.maxSize;
        return n;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = this.front; i < this.front + validNumbers(); i++) {
            System.out.printf("arr[%d]=%d\t", i % this.maxSize, arr[i % this.maxSize]);
        }
    }

    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.arr[this.front];
    }

}
