package com.xkc.datastruce.linkedlist;

import lombok.Data;

/**
 * 单链表
 *
 * @author xukechen
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(new HeroNode(1, "宋江"));
//        singleLinkedList.add(new HeroNode(2, "卢俊义"));
//        singleLinkedList.add(new HeroNode(3, "吴用"));
        singleLinkedList.addByOrder(new SingleLinkedList.HeroNode(1, "宋江"));
        singleLinkedList.addByOrder(new SingleLinkedList.HeroNode(2, "卢俊义"));
        singleLinkedList.addByOrder(new SingleLinkedList.HeroNode(4, "林冲"));
        singleLinkedList.addByOrder(new SingleLinkedList.HeroNode(3, "吴用"));
//        singleLinkedList.reverse();
//        singleLinkedList.show();
        singleLinkedList.recursion();
    }

}

class SingleLinkedList {

    /**
     * 初始化空头节点, 不存放具体数据
     */
    private HeroNode headNode = new HeroNode(0, "");

    public void add(HeroNode node) {
        HeroNode last = getLast(headNode);
        last.setNext(node);
    }

    /**
     * 根据排名添加节点, 存在抛出异常
     *
     * @param headNode
     */
    public void addByOrder(HeroNode headNode) {
        HeroNode tmp = this.headNode;
        // 添加的编号是否存在
        boolean flag = false;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            if (tmp.getNext().getNo() == headNode.getNo()) {
                flag = true;
                break;
            }
            if (tmp.getNext().getNo() > headNode.getNo()) {
                break;
            }
            tmp = tmp.getNext();
        }

        if (flag) {
            throw new RuntimeException("添加编号已存在");
        }

        headNode.setNext(tmp.getNext());
        tmp.setNext(headNode);
    }

    public void show() {
        if (headNode.getNext() == null) {
            System.out.println("链表为空！");
        } else {
            HeroNode tmp = headNode.getNext();
            while (true) {
                System.out.println(tmp);
                if (tmp.getNext() == null) {
                    break;
                }
                tmp = tmp.getNext();
            }
        }
    }

    /**
     * 获取最后一个节点
     *
     * @param node
     * @return
     */
    private HeroNode getLast(HeroNode node) {
        if (node.getNext() == null) {
            return node;
        }
        return getLast(node.getNext());
    }

    private void updateByNo(HeroNode newHeroNode) {


    }

    private void del(int no) {
        HeroNode temp = headNode;

        temp.setNext(temp.getNext().getNext());
    }

    /**
     * 反转链表
     */
    public void reverse() {
        // 空链表或只有一个节点, 不进行任何操作
        if (!(headNode.next == null || headNode.next.next == null)) {
            // 新头节点
            HeroNode newHeroNode = new HeroNode(0, "");
            // 遍历原列表指针
            HeroNode cur = headNode.next;
            // 当前节点下一个节点
            HeroNode curNext;

            while (cur != null) {
                // 临时保存  当前节点的下一个节点
                curNext = cur.next;

                // 新链表头节点的下一个挂在到cur的next
                // 将cur挂到头节点的下一个
                cur.next = newHeroNode.next;
                newHeroNode.next = cur;

                // cur后移
                cur = curNext;
            }
            // 挂到原列表头节点上
            headNode.next = newHeroNode.next;
        }
    }

    public void recursion() {
        if (headNode.next == null) {
            return;
        }
        recursionShow(headNode.next);
    }

    public void recursionShow(HeroNode node) {
        if (node != null && node.next != null) {
            recursionShow(node.next);
        }
        System.out.println(node);
    }

    @Data
    static class HeroNode {

        public int no;
        public String nickName;
        public HeroNode next;

        public HeroNode(int no, String nickName) {
            this.no = no;
            this.nickName = nickName;
        }

    }

}
