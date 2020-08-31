package com.xkc.algorithms.search;

/**
 * 顺序查找
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] array = {8, 7, 77, 9, 5, 2, 4};
        int index = seqSearch(array, 9);
        System.out.println(index);
    }

    private static int seqSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
