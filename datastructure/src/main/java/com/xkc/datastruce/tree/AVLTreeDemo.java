package com.xkc.datastruce.tree;

import lombok.Data;

/**
 * AVL树, 平衡树： 左子树和右子树高度绝对值不大于1
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] array = {4, 3, 6, 5, 7, 8};

        AVLTree avlTree = new AVLTree();

        // 添加节点  二叉排序树
        for (int i = 0; i < array.length; i++) {

        }

        // 左旋

    }
}


class AVLTree {

    private AVLNode root;


}


@Data
class AVLNode {

    private int value;

    private AVLNode left;

    private AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    // 返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    // 返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    // 返回当前节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // 左旋
    private void leftRotate() {
        // 当前根节点的值创建新的节点
        AVLNode avlNode = new AVLNode(value);

        // 新节点的左子树设置成当前节点的左子树
        avlNode.left = left;

        // 新节点的右子树设置成当前节点的右子树的左子树
        avlNode.right = right.left;

        // 当前节点的值换成右子节点的值
        value = right.value;

        // 当前节点的右子树设置成右子树的右子树
        right = right.right;

        // 当前节点的左子节点设置成新节点
        left = avlNode;
    }

    // 右旋
    public void rightRotate() {
        // 当前根节点的值创建新的节点
        AVLNode avlNode = new AVLNode(value);

        // 新节点的右子树设置成当前节点的右子树
        avlNode.right = right;

        // 新节点的左子树设置成当前节点的左子树的右子树
        avlNode.left = left.right;

        // 当前节点的值换成左子节点的值
        value = left.value;

        // 当前节点的左子树设置成左子树的左子树
        left = left.left;

        // 当前节点的右子节点设置成新节点
        right = avlNode;

    }

    public void add(AVLNode avlNode) {
        // 当添加完一个节点, 如果右子树的高度 - 左子树的高度 > 1, 左旋
        if (rightHeight() - leftHeight() > 1) {
            // 右子树的左子树的高度大于右子树的右子树高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                // 先对当前节点右节点进行右旋
                right.rightRotate();
            }
            leftRotate();
            // !!!  必须要
            return;
        }

        // 当添加完一个节点, 如果左子树的高度 - 右子树的高度 > 1, 右旋
        if (leftHeight() - rightHeight() > 1) {
            // 左子树的右子树的高度大于左子树的左子树高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                // 先对当前节点左节点进行左旋
                left.leftRotate();
            }
            // 再对当前节点右旋
            rightRotate();
        }

    }

}
