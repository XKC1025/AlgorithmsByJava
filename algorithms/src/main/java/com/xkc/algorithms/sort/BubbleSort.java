package com.xkc.algorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序： 3, 9, -1, 10, -2
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] array = {20, 11, 10, 9, 3, -1, -2, -3};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

}