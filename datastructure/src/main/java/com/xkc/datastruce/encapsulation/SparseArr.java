package com.xkc.datastruce.encapsulation;

import java.util.Arrays;

/**
 * 稀疏数组
 *
 * @author xukechen
 */
public class SparseArr {

    public static void main(String[] args) {
        // 创建一个 11*11 大小的数组
        // 0代表无棋子， 1黑子，2白子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        // 统计非0个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];

        // 稀疏数组第一行保存原数组  行数  列数  非0数
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 第几个非0数
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        // 稀疏数组恢复成元数组
        int i = sparseArr[0][0];
        int j = sparseArr[0][1];
        int k = sparseArr[0][2];

        int[][] newSparseArr = new int[i][j];
        for (int m = 1; m <= k; m++) {
            newSparseArr[sparseArr[m][0]][sparseArr[m][1]] = sparseArr[m][2];
        }
        System.out.println(Arrays.deepToString(newSparseArr));
    }

}
