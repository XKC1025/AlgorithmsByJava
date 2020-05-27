package com.xkc.datastruce.queue;

/**
 * 队列
 *
 * @author xukechen
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.add(1);
        arrayQueue.show();
        System.out.println(arrayQueue.getFirst());
    }
}

class ArrayQueue {

    /**
     * 队列最大容量
     */
    private int maxSize;

    /**
     * 队列头, 队列第一个数据的前一个位置
     */
    private int front;

    /**
     * 队列尾, 队列最后一个数据
     */
    private int rear;

    /**
     * 队列具体容器
     */
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public void add(int arg) {
        if (this.isFull()) {
            System.out.println("队列已满, 不能添加数据！");
        } else {
            this.arr[++rear] = arg;
        }
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空, 不能取数据！");
        }
        return this.arr[++front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空！");
        } else {
            for (int i = 0; i < this.arr.length; i++) {
                System.out.printf("arr[%d]=[%d]\n", i, this.arr[i]);
            }
        }
    }

    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空, 不能取数据！");
        } else {
            return this.arr[this.front + 1];
        }
    }

}
