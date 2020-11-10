package com.xkc.algorithms.dynamic;

/**
 * 动态规划 背包问题
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        // 物品重量
        int[] weight = {1, 4, 3};
        // 物品价值
        int[] value = {1500, 3000, 2000};

        // 背包容量
        int m = 4;
        // 物品的个数
        int n = value.length;

        // 创建二维数组, table[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] table = new int[n + 1][m + 1];
        // 记录商品放入数量
        int[][] path = new int[n + 1][m + 1];

        // 1. table[i][0] = table[0][j] = 0
        // 动态规划
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                // i从1开始, value[i - 1]和weight[i - 1]
                if (weight[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    // table[i][j] = Math.max(table[i - 1][j], value[i - 1] + table[i - 1][j - weight[i - 1]]);
                    // 等价上边一行
                    if (table[i - 1][j] < value[i - 1] + table[i - 1][j - weight[i - 1]]) {
                        table[i][j] = value[i - 1] + table[i - 1][j - weight[i - 1]];
                        path[i][j] = 1;
                    } else {
                        table[i][j] = table[i - 1][j];
                    }
                }
            }
        }

        // 放入的商品
        int i = path.length - 1;
        int j = path[0].length - 1;

        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= weight[i - 1];
            }
            i--;
        }
    }

}
