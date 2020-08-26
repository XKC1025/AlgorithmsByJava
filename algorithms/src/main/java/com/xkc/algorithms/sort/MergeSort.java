package com.xkc.algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            array[i] = (int) (Math.random() * 10000000);
        }

        mergeSort(array, 0, array.length - 1, new int[array.length]);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 分 + 和的方法
     *
     * @param array
     */
    private static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int middle = (left + right) / 2;

            // 向左递归分解
            mergeSort(array, left, middle, temp);

            // 向右递归分解
            mergeSort(array, middle + 1, right, temp);

            // 每分解一次就合并一次
            merge(array, left, middle, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param array  待排序的数组
     * @param left   左边有序序列初始索引
     * @param middle
     * @param right
     * @param temp   中转的数组
     */
    private static void merge(int[] array, int left, int middle, int right, int[] temp) {
        // 初始化i, 左边有序序列索引
        int i = left;
        // 初始化j, 右边有序序列索引
        int j = middle + 1;
        // 指向temp数组的当前索引
        int t = 0;

        // 1.先把左右两边有序数组 按照规则填充到temp数组, 知道左右两边的有序序列, 任意一方处理完毕为止
        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) {
                temp[t] = array[i];
                t++;
                i++;
            } else {
                temp[t] = array[j];
                t++;
                j++;
            }
        }

        // 2.把剩余的一边依次填充到temp数组
        while (i <= middle) {
            temp[t] = array[i];
            i++;
            t++;
        }

        while (j <= right) {
            temp[t] = array[j];
            j++;
            t++;
        }

        // 3.将temp数组拷贝到array, 并不是每次都全部拷贝
        t = 0;
        int tempLeft = left;
        // 第一次合并tempLeft = 0, right = 1
        // 第二次合并tempLeft = 2, right = 3
        // 第三次合并tempLeft = 0, right = 3
        // 最后一次合并tempLeft = 0, right = 7
//        System.out.println("tempLeft=" + tempLeft + ", right=" + right);
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }

}
