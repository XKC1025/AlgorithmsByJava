package com.xkc.algorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序： 3, 9, -1, 10, -2
 */
public class BubbleSort {

    private static final int[] array = {20, 11, 10, 9, 3, -1, -2, -3};

    public static void main(String[] args) {

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

            System.out.println("第" + (i + 1) + "次排序: " + Arrays.toString(array));

            if (!swap) {
                break;
            }
        }
    }

}