package com.xkc.algorithms.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class FibonacciSearch {

    private static final int maxSize = 20;

    public static void main(String[] args) {
        int[] array = {1, 8, 10, 89, 1000, 1234};
        fibonacciSearch(array, 10);
    }

    private static int[] fib() {
        int[] fibArray = new int[maxSize];
        fibArray[0] = 1;
        fibArray[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }

    /**
     * @param array 查找数列
     * @param key   查找数
     * @return
     */
    private static int fibonacciSearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        // 斐波那契数列分割数值下标
        int k = 0;
        int midIndex = 0;
        int[] fib = fib();

        // 获取斐波那契分割数值下标
        while (high > fib[k] - 1) {
            k++;
        }

        // fib[k]可能大于array的长度  Arrays 0填充
        int[] temp = Arrays.copyOf(array, fib[k]);

        // 扩充成可以找到黄金分割点的数组
        // temp = {1, 8, 10, 89, 1000, 1234} => {1, 8, 10, 89, 1000, 1234, 1234, 1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = array[high];
        }

        while (low <= high) {
            midIndex = low + fib[k - 1] - 1;
            // 继续向数组左边查找
            if (key < temp[midIndex]) {
                high = midIndex - 1;
                k--;
            } else if (key > temp[midIndex]) {
                low = midIndex + 1;
                k -= 2;
            } else {
                return Math.min(midIndex, high);
            }
        }

        return -1;
    }

}
