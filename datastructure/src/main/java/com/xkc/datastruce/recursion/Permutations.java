package com.xkc.datastruce.recursion;

/**
 * 全排列
 */
public class Permutations {

    private static final int[] nums = {1, 2, 3};

    public static void displayPerm(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void perm(int[] nums, int start, int end) {
        if (start == end) {
            displayPerm(nums);
        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, i, start);
                perm(nums, start + 1, end);
                swap(nums, i, start);
            }
        }
    }

    public static void main(String[] args) {
        perm(nums, 0, nums.length - 1);
    }

}
