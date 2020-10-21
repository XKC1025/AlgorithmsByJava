package com.xkc.datastruce.tree;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 赫夫曼树:
 *  给定n个权值作为叶子节点, 构造一棵二叉树, 若该树的带权路径长度(WPL)最小, 成为最优二叉树, 也是赫夫曼树
 *  权值较大的节点离根节点较近
 *
 * 路径：
 *  在一棵树中, 从一个节点往下达到的孩子或孙子节点之间的通路, 称为路径, 通路中的分支数目成为路径长度。
 *  若规定根节点的层数为1, 则从根节点到第L层节点的路径长度为L-1
 *
 * 节点的权及带权路径长度：
 *  若将树中的节点赋给一个有着某种含义的数值, 这个数值称为该节点的权。
 *  从根节点到该节点之间的路径长度与该节点的权的乘积
 *
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] array = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(array);
        huffmanTree.preOrder();
    }

    // 创建赫夫曼树
    private static Node createHuffmanTree(int[] array) {
        List<Node> nodes = Arrays.stream(array).mapToObj(Node::new).collect(Collectors.toList());

        while (nodes.size() > 1) {
            // 从小到大排序
            Collections.sort(nodes);

            // 取出根节点权值最小的二叉树
            // 取出权值最小的节点
            Node left = nodes.get(0);
            // 取出权值第二小的二叉树
            Node right = nodes.get(1);

            // 构建新的二叉树
            Node parent = new Node(left.getValue() + right.getValue());
            parent.setLeft(left);
            parent.setRight(right);

            // 删除处理过的二叉树
            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }

        // 返回root
        return nodes.get(0);

    }

}

@Data
class Node implements Comparable<Node> {

    // 节点权值
    private int value;

    // 左子节点
    private Node left;

    // 右子节点
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.getValue();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (Objects.nonNull(left)) {
            left.preOrder();
        }
        if (Objects.nonNull(right)) {
            right.preOrder();
        }
    }

}
