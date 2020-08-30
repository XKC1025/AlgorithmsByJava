package com.xkc.algorithms.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            array[i] = (int) (Math.random() * 10000000);
        }

        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void radixSort(int[] array) {
        // 桶
        int[][] bucket = new int[10][array.length];
        // 桶位有效元素个数
        int[] bucketElementCounts = new int[10];

        // 最大值
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }

        // 最大值位数
        int maxLength = String.valueOf(max).length();

        // 排序轮数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 放入桶中
            for (int value : array) {
                int digitOfElement = value / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }

            // 从桶中按顺序取
            // 原数组下标
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        array[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }

}

