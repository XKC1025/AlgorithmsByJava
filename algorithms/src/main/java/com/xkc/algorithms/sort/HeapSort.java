package com.xkc.algorithms.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {4, 6, 8, 5, 9, -1, 90, 89};
        heapSort(array);
    }

    private static void heapSort(int[] array) {
        int temp = 0;

        // 先调整成一个大顶堆
        // int i = array.length / 2 - 1 最后一个非叶子节点的下标
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

        // 交换堆顶和末尾元素
        for (int j = array.length - 1; j > 0; j--) {
            temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            // 继续构建大顶堆
            adjustHeap(array, 0, j);
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * 将一个数组调整成大顶堆
     * <p>
     * 将以i对应的非叶子节点的数调整成大顶堆
     * eg: {4, 6, 8, 5, 9} i = 1 调整成: {4, 9, 8, 5, 6}
     * {4, 9, 8, 5, 6} i = 0 调整成: {9, 6, 8, 5, 4}
     *
     * @param array  待调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整, 逐渐减少
     */
    private static void adjustHeap(int[] array, int i, int length) {
        // 暂存当前值
        int temp = array[i];

        // 开始调整
        // k = i * 2 + 1   i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 左子节点小于右子节点
            if (k + 1 < length && array[k] < array[k + 1]) {
                // 指向右子节点
                k++;
            }
            // k已经指向左子节点右子节点的最大值, 如果子节点大于父节点, 交换节点顺序
            if (array[k] > temp) {
                array[i] = array[k];
                // !!!!! 很重要的一步
                // i指向k, 继续循环比较
                i = k;
            } else {
                // 从左至右, 从下至上调整
                break;
            }
        }

        // for循环结束, 最大数已经放到i为父节点的树（局部）

        // 将temp放到调整后的位置
        array[i] = temp;
    }

}
