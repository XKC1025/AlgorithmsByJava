package com.xkc.datastruce.recursion;

/**
 * 八皇后问题
 */
public class Queen {

    private static final int MAX = 8;

    private static final int[] queen = new int[MAX];

    private static int count = 0;

    private static int judgeCount = 0;

    public static void main(String[] args) {
        setQueen(0);
        System.out.println(count);
        System.out.println(judgeCount);
    }

    /**
     * 放置第n个皇后
     *
     * @param n
     */
    private static void setQueen(int n) {
        // 放置第9个皇后时, 前8个已经放好
        if (n == MAX) {
            displayLocation();
            return;
        }

        // 放入皇后, 判断是否冲突
        for (int i = 0; i < MAX; i++) {
            // 把第n个皇后放到n行的每一列
            queen[n] = i;
            // 判断是否冲突
            if (judge(n)) {
                // 放置第n+1个
                setQueen(n + 1);
            }
        }
    }

    /**
     * 放置第n个皇后时，检查是否与前 n-1个已经放置的皇后冲突
     *
     * @param n
     * @return
     */
    private static boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 同一列 or 在对角线
            if (queen[i] == queen[n] || Math.abs(n - i) == Math.abs(queen[n] - queen[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印皇后位置
     */
    private static void displayLocation() {
        for (int i = 0; i < queen.length; i++) {
            System.out.print(queen[i] + " ");
        }
        System.out.println();
        count++;
    }

}
