package com.xkc.algorithms.dac;

/**
 * 汉诺塔 分治算法
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(10, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        // num == 1  a -> c
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            // 先把最上边的盘  a -> b
            hanoiTower(num - 1, a, c, b);
            // 把最下边的盘   a -> c
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            // 把b塔所有盘    b -> c
            hanoiTower(num - 1, b, a, c);
        }
    }

}
