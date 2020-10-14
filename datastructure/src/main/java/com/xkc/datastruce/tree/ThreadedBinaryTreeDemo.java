package com.xkc.datastruce.tree;

import lombok.Data;

import java.util.Objects;

/**
 * 线索化二叉树:
 * n个节点的二叉链表中含有 n+1 = [2n-(n-1)]个空指针域。
 * 利用二叉链表中的空指针域，存放指向节点在某种遍历次序下的前驱节点和后继节点
 * 附加的指针称为"线索"
 * <p>
 * 分为前序、中序、后序线索二叉树
 * <p>
 * 一个结点的前一个节点，称为前驱节点
 * 一个结点的后一个节点，称为后继节点
 * <p>
 * left和right指针:
 * left指向左子树或q前驱节点
 * right指向右子树或后继节点
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        // 中序遍历 4, 2, 5, 1, 6, 3

        HeroNode2 heroNode1 = new HeroNode2(1, "111");
        HeroNode2 heroNode2 = new HeroNode2(2, "222");
        HeroNode2 heroNode3 = new HeroNode2(3, "333");
        HeroNode2 heroNode4 = new HeroNode2(4, "444");
        HeroNode2 heroNode5 = new HeroNode2(5, "555");
        HeroNode2 heroNode6 = new HeroNode2(6, "666");

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);

        threadedBinaryTree.threadedNodes(heroNode1);

        System.out.println(heroNode4.getRight());
        System.out.println(heroNode5.getRight());
        System.out.println(heroNode6.getLeft());
        System.out.println(heroNode6.getRight());

    }

}

@Data
class ThreadedBinaryTree {

    private HeroNode2 root;

    // 当前节点的前驱节点
    // 递归进行线索化时, 总是保留前驱节点
    private HeroNode2 preNode;

    // 中序线索化方法
    public void threadedNodes(HeroNode2 node) {
        if (Objects.isNull(node)) {
            return;
        }
        // 先线索化左子树
        threadedNodes(node.getLeft());

        // 线索化当前节点
        if (Objects.isNull(node.getLeft())) {
            // 当前节点的left指向前驱节点
            node.setLeft(preNode);
            // 修改当前节点的左指针类型
            node.setLeftType(1);
        }

        // 处理后继节点
        if (Objects.nonNull(preNode) && Objects.isNull(preNode.getRight())) {
            // 前驱节点的右指针指向当前节点
            preNode.setRight(node);
            // 修改前驱节点的右指针类型
            preNode.setRightType(1);
        }

        // !!! 每处理一个节点, 让当前节点是下一个节点的前驱节点
        preNode = node;

        // 线索化右子树
        threadedNodes(node.getRight());
    }
}

@Data
class HeroNode2 {

    private Integer no;

    private String name;

    private HeroNode2 left;

    private HeroNode2 right;

    // 0:指向左子树 1:指向前驱节点
    private int leftType;

    // 0:指向右子树 1:指向后继节点
    private int rightType;

    public HeroNode2(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }

}

