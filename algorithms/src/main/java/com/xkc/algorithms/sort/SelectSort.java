package com.xkc.algorithms.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {11, 10, 5, 8, 2, 1, 3, 4, 9, 7, 12};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

}
