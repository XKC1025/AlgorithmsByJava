package com.xkc.datastruce.tree;

import lombok.Data;

import java.util.Objects;

/**
 * 二叉树
 */
public class BinaryTree {

    public static void main(String[] args) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        HeroNode heroNode1 = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "卢俊义");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "关胜");

        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);

        myBinaryTree.setRoot(heroNode1);

//        myBinaryTree.preOrder();
//        myBinaryTree.infixOrder();
//        myBinaryTree.postOrder();

        HeroNode heroNode = myBinaryTree.preOrderSearch(5);
        System.out.println(heroNode);
    }

}

@Data
class MyBinaryTree {

    private HeroNode root;

    // 前序遍历
    public void preOrder() {
        if (Objects.nonNull(this.root)) {
            this.root.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }
    }

    // 前序查找
    public HeroNode preOrderSearch(int no) {
        if (Objects.nonNull(this.root)) {
            return this.root.preOrderSearch(no);
        }
        return null;
    }

    // 中序查找
    // 后序查找

    // 删除节点
    public void delNode(int no) {
        if (Objects.nonNull(this.root)) {
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                this.root.delNode(no);
            }
        }
    }

}

@Data
class HeroNode {

    private Integer no;

    private String name;

    private HeroNode left;

    private HeroNode right;

    public HeroNode(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    // 先输出当前节点
    // 如果左子节点不为空, 递归前序遍历
    // 如果右子节点不为空, 递归前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    // 如果当前节点左子节点不为空, 递归中序遍历
    // 输出当前节点
    // 如果当前节点右子节点不为空, 递归中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    // 如果当前左子节点不为空, 递归后序遍历
    // 如果当前右子节点不为空, 递归后序遍历
    // 输出当前节点
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (Objects.nonNull(this.left)) {
            resNode = this.left.preOrderSearch(no);
        }
        if (Objects.nonNull(resNode)) {
            return resNode;
        }
        if (Objects.nonNull(this.right)) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    // 中序查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (Objects.nonNull(this.left)) {
            resNode = this.left.preOrderSearch(no);
        }
        if (Objects.nonNull(resNode)) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (Objects.nonNull(this.right)) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    // 后序查找
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (Objects.nonNull(this.left)) {
            resNode = this.left.preOrderSearch(no);
        }
        if (Objects.nonNull(resNode)) {
            return resNode;
        }
        if (Objects.nonNull(this.right)) {
            resNode = this.right.preOrderSearch(no);
        }
        if (Objects.nonNull(resNode)) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }

    // 删除节点
    public void delNode(int no) {
        if (Objects.nonNull(this.left) && this.left.no == no) {
            this.left = null;
            return;
        }

        if (Objects.nonNull(this.right) && this.right.no == no) {
            this.right = null;
            return;
        }

        if (Objects.nonNull(this.left)) {
            this.left.delNode(no);
        }

        if (Objects.nonNull(this.right)) {
            this.right.delNode(no);
        }
    }

}
