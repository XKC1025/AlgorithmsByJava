package com.xkc.algorithms.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {11, 10, 5, 8, 2, 1, 3, 4, 9, 7, 12, -1};
//        shellSortExchange(array);
        shellSortMove(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 交换法
     *
     * @param array
     */
    private static void shellSortExchange(int[] array) {
        int temp;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 移动法
     *
     * @param array
     */
    private static void shellSortMove(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[i];
                if (array[j] < array[j - gap]) {
                    while ((j - gap) >= 0 && temp < (array[j - gap])) {
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    array[j] = temp;
                }
            }
        }
    }

}
