package com.xkc.algorithms.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {11, 10, 5, 8, 2, 1, 3, 4, 9, 7, 12};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(int[] array) {
        // 待插入的数
        int insertVal;
        // 插入位置
        int insertIndex;

        for (int i = 1; i < array.length; i++) {
            insertVal = array[i];
            insertIndex = i - 1;

            // 寻找插入位置  前一个数覆盖后一个数, 向前遍历
            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }

            // 找到插入位置
            array[insertIndex + 1] = insertVal;
        }
    }

}
