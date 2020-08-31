package com.xkc.algorithms.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找： 先排序
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 6, 10, 89, 999, 1000, 1000, 1000, 1234};
        List<Integer> binarySearch2 = binarySearch2(array, 0, array.length - 1, 1000);
        System.out.println(binarySearch2);
    }

    private static int binarySearch(int[] array, int left, int right, int target) {
        if (left > right) {
            return -1;
        } else {
            int middle = (left + right) / 2;
            if (target < array[middle]) {
                return binarySearch(array, left, middle - 1, target);
            } else if (target > array[middle]) {
                return binarySearch(array, middle + 1, right, target);
            } else {
                return middle;
            }
        }
    }

    private static List<Integer> binarySearch2(int[] array, int left, int right, int target) {
        if (left > right) {
            return new ArrayList<>();
        } else {
            int middle = (left + right) / 2;
            if (target < array[middle]) {
                return binarySearch2(array, left, middle - 1, target);
            } else if (target > array[middle]) {
                return binarySearch2(array, middle + 1, right, target);
            } else {
                List<Integer> resultIndex = new ArrayList<>();
                resultIndex.add(middle);

                int temp = middle - 1;
                // 向左扫描
                while (temp >= 0 && array[temp] == target) {
                    resultIndex.add(temp);
                    temp--;
                }
                temp = middle + 1;
                // 向右扫描
                while (temp < array.length - 1 && array[temp] == target) {
                    resultIndex.add(temp);
                    temp++;
                }
                return resultIndex;
            }
        }
    }

}
