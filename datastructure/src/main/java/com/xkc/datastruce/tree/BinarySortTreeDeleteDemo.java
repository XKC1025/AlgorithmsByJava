package com.xkc.datastruce.tree;

import lombok.Data;

import java.util.Objects;

/**
 * 二叉排序树删除节点
 */
public class BinarySortTreeDeleteDemo {

    public static void main(String[] args) {

    }

}

@Data
class BinarySortTreeDelete {
    private Node2 root;

    public Node2 search(int value) {
        return root.search(value);
    }

    public Node2 searchParent(int value) {
        return root.searchParent(value);
    }

    /**
     * 删除node2为根节点的二叉排序树的最小节点
     *
     * @param node2 传入的节点（当做二叉排序树的根节点）
     * @return 返回以node2为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node2 node2) {
        Node2 target = node2;
        // 循环查找左子节点, 找到最小值
        while (Objects.nonNull(target.getLeft())) {
            target = target.getLeft();
        }
        // target指向最小值
        // 删除最小节点
        int value = target.getValue();
        delNode2(value);
        return value;
    }

    public void delNode2(int value) {
        // 待删除的节点
        Node2 targetNode = search(value);
        if (Objects.isNull(targetNode)) {
            return;
        }

        // 只有一个root节点
        if (Objects.isNull(root.getLeft()) && Objects.isNull(root.getRight())) {
            root = null;
            return;
        }

        // 待删除节点的父节点
        Node2 parentNode = searchParent(value);

        // 叶子节点
        if (Objects.isNull(targetNode.getLeft()) && Objects.isNull(targetNode.getRight())) {
            if (targetNode == parentNode.getLeft()) {
                parentNode.setLeft(null);
            }
            if (targetNode == parentNode.getRight()) {
                parentNode.setRight(null);
            }
        } else if (Objects.nonNull(targetNode.getLeft()) && Objects.nonNull(targetNode.getRight())) {
            // 左子节点和右子节点都存在
            // 找右边最小值的节点 或 左边最大值的节点
            int minValue = delRightTreeMin(targetNode.getRight());
            targetNode.setValue(minValue);
        } else {
            // 要删除的节点只有左子节点
            if (Objects.nonNull(targetNode.getLeft())) {
                if (Objects.nonNull(parentNode)) {
                    // 要删除的节点是parentNode的左子节点
                    if (parentNode.getLeft().getValue() == value) {
                        parentNode.setLeft(targetNode.getLeft());
                    }
                    // 要删除的节点是parentNode的右子节点
                    if (parentNode.getRight().getValue() == value) {
                        parentNode.setRight(targetNode.getLeft());
                    }
                } else {
                    root = targetNode.getLeft();
                }
            }

            // 要删除的节点只有右子节点
            if (Objects.nonNull(targetNode.getRight())) {
                if (Objects.nonNull(parentNode)) {
                    // 要删除的节点是parentNode的左子节点
                    if (parentNode.getLeft().getValue() == value) {
                        parentNode.setLeft(targetNode.getRight());
                    }
                    // 要删除的节点是parentNode的右子节点
                    if (parentNode.getRight().getValue() == value) {
                        parentNode.setRight(targetNode.getRight());
                    }
                } else {
                    root = targetNode.getRight();
                }
            }
        }
    }

}

@Data
class Node2 {
    private int value;
    private Node2 left;
    private Node2 right;

    public Node2(int value) {
        this.value = value;
    }

    /**
     * 查询待删除的节点
     *
     * @param value
     * @return
     */
    public Node2 search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            // 向左子树查找
            if (Objects.isNull(this.getLeft())) {
                return null;
            }
            return this.getLeft().search(value);
        } else {
            // 向右子树查找
            if (Objects.isNull(this.getRight())) {
                return null;
            }
            return this.getRight().search(value);
        }
    }

    /**
     * 查询待删除节点的父节点
     *
     * @param value
     * @return
     */
    public Node2 searchParent(int value) {
        if ((Objects.nonNull(this.getLeft()) && this.getLeft().getValue() == value)
                || (Objects.nonNull(this.getRight()) && this.getRight().getValue() == value)) {
            return this;
        } else {
            // 查找的值小于当前节点, 向左子树查询
            if (Objects.isNull(this.getLeft()) && value < this.getValue()) {
                return this.getLeft().searchParent(value);
            } else if (Objects.nonNull(this.getRight()) && value >= this.getValue()) {
                // 向右子树查找
                return this.getRight().searchParent(value);
            } else {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Node2{" +
                "value=" + value +
                '}';
    }

}
