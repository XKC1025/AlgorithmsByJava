package com.xkc.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序，对冒泡排序的改进
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {-9, 78, 0, 23, -567, -70};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int temp;
        // 中值
        int pivot = array[(left + right) / 2];

        // 循环 让比pivot小的值放到左边, 比pivot大的值放到右边
        while (l < r) {
            while (array[l] < pivot) {
                l++;
            }
            while(array[r] > pivot){
                r--;
            }

            if (l >= r) {
                break;
            }

            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            // 中值可能会被调整位置, 防止死循环
            if (array[l] == pivot) {
                r--;
            }
            if (array[r] == pivot) {
                l++;
            }
        }

        // 防止栈溢出
        if (l == r) {
            l++;
            r--;
        }

        // 递归调用
        // 向左递归
        if (left < r) {
            quickSort(array, left, r);
        }

        // 向右递归
        if (right > l) {
            quickSort(array, l, right);
        }

    }

}
