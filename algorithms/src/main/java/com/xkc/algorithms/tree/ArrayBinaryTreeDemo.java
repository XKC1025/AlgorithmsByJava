package com.xkc.algorithms.tree;

import lombok.Data;

/**
 * 顺序存储二叉树：用数组存储二叉树, 只针对完全二叉树
 * 第n个元素的左子节点为(2n + 1)
 * 第n个元素的右子节点为(2n + 2)
 * 第n个元素的父节点为(n - 1) / 2
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        arrayBinaryTree.preOrder(0);
        arrayBinaryTree.infixOrder(0);
        arrayBinaryTree.postOrder(0);
    }

}

@Data
class ArrayBinaryTree {
    // 存储数据节点的数组
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 顺序存储二叉树前序遍历
    public void preOrder(int index) {
        // 数组为空或者index>数组长度
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        // 输出当前元素
        System.out.println(arr[index]);

        // 向左递归
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }

        // 向右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    // 顺序存储二叉树中序遍历
    public void infixOrder(int index) {
        // 数组为空或者index>数组长度
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        // 向左递归
        if ((index * 2 + 1) < arr.length) {
            infixOrder(index * 2 + 1);
        }

        // 输出当前元素
        System.out.println(arr[index]);

        // 向右递归
        if ((index * 2 + 2) < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    // 顺序存储二叉树后序遍历
    public void postOrder(int index) {
        // 数组为空或者index>数组长度
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        // 向左递归
        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }

        // 向右递归
        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }

        // 输出当前元素
        System.out.println(arr[index]);
    }

}
