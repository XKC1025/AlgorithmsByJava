package com.xkc.datastruce.linkedlist;

import lombok.Data;

/**
 * 双向链表
 * @author xukechen
 */
@Data
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

    }

}

@Data
class DoubleLinkedList {

    private HeroNode2 headNode = new HeroNode2();

    public HeroNode2 getHead() {
        return headNode;
    }

    public void add(HeroNode2 node) {
        HeroNode2 tmp = headNode;

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        node.pre = tmp;
    }

    @Data
    static class HeroNode2 {

        public int no;
        public String nickName;
        public HeroNode2 next;
        public HeroNode2 pre;

    }

}
