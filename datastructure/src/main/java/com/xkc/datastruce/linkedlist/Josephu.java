package com.xkc.datastruce.linkedlist;

import lombok.Data;

/**
 * 约瑟夫问题
 */
@Data
public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
//        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1, 2, 5);
    }

}

/**
 * 单向环形链表
 */
@Data
class CircleSingleLinkedList {

    // 创建第一个Boy
    private Boy firstBoy = null;

    /**
     * 添加Boy节点
     *
     * @param nums
     */
    public void addBoy(int nums) {
        if (nums <= 0) {
            return;
        }

        // 辅助指针, 帮助构建环形列表
        Boy curBoy = null;

        // 根据编号 创建Boy节点
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                firstBoy = boy;
                firstBoy.setNext(firstBoy);
                curBoy = firstBoy;
            } else {
                curBoy.setNext(boy);
                boy.setNext(firstBoy);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        Boy next = firstBoy;
        while (next != null) {
            System.out.println(next.no);
            if (next.getNext() == firstBoy) {
                break;
            }
            next = next.getNext();
        }
    }

    /**
     * 计算Boy出圈顺序
     *
     * @param startNo  从第几个Boy开始数数
     * @param countNum 数几下
     * @param nums     最初有多少节点
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (firstBoy == null || startNo < 1 || startNo > nums) {
            return;
        }

        // 头指针指向 countNum 位置
        while (true) {
            if (firstBoy.no == startNo) {
                break;
            } else {
                firstBoy = firstBoy.next;
            }
        }

        // 创建辅助指针
        Boy helper = firstBoy;

        // 辅助指针指向头节点的前一个
        while (helper.getNext() != firstBoy) {
            helper = helper.getNext();
        }

        while (true) {
            // helper和firsBoy 同时移动 countNum - 1 下
            for (int i = 0; i < countNum - 1; i++) {
                firstBoy = firstBoy.next;
                helper = helper.next;
            }
            System.out.println(firstBoy.no);

            firstBoy = firstBoy.next;
            helper.next = firstBoy;

            if (helper == firstBoy) {
                System.out.println(firstBoy.no);
                break;
            }
        }
    }

}

@Data
class Boy {

    public int no;

    public Boy next;

    public Boy(int no) {
        this.no = no;
    }
}
