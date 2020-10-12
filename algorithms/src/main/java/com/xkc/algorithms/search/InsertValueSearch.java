package com.xkc.algorithms.search;

/**
 * 在二分法查找的基础上，自适应查找
 * midIndex = left + (right - left) * (findValue - array[left]) / (array[right] - array[left]);
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] array = {1, 6, 10, 89, 999, 1000, 1000, 1000, 1234};
        int index = insertValueSearch(array, 0, array.length - 1, 1234);
        System.out.println(index);
    }

    private static int insertValueSearch(int[] array, int left, int right, int findValue) {
        if (left > right || findValue < array[0] || findValue > array[array.length - 1]) {
            return -1;
        }

        // 求midIndex
        int midIndex = left + (right - left) * (findValue - array[left]) / (array[right] - array[left]);
        int midValue = array[midIndex];

        // 向右递归
        if (findValue > midValue) {
            return insertValueSearch(array, midIndex + 1, right, findValue);
        } else if (findValue < midValue) {
            return insertValueSearch(array, left, right, midIndex - 1);
        } else {
            return midIndex;
        }
    }

}
