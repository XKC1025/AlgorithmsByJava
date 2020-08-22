package com.xkc.datastruce.recursion;

/**
 * 全排列
 */
public class Permutations {

    private static final int[] nums = {1, 2, 3, 4, 5, 6};

    private static void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    private static void displayNums() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    private static void perm(int[] nums, int start, int end) {
        if (start == end) {
            displayNums();
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
