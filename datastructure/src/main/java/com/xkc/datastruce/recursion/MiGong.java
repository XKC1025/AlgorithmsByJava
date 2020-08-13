package com.xkc.datastruce.recursion;

/**
 * 迷宫
 *
 * @author 89804
 */
public class MiGong {

    public static void main(String[] args) {
        int[][] map = new int[8][7];

        // 1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = map[3][2] = map[2][2] = 1;

        System.out.println(setWay(map, 1, 1));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 找到 (6, 5)
     * <p>
     * 约定： 当map[i][j]为0, 表示当前点没被走过; 当为1时, 表示墙; 当为2表示通路可以走;当为3时表示已经走过，但是走不通
     * 策略：下->右->上->左   如果走不通，再回溯
     *
     * @param map 地图
     * @param i   起始行
     * @param j   起始列
     * @return 找到出口
     */
    private static boolean setWay(int[][] map, int i, int j) {
        // 找到出口
        if (map[4][1] == 2) {
            return true;
        } else {
            // 当前点还没走过
            if (map[i][j] == 0) {
                map[i][j] = 2;

                // 向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 置为死路
                    map[i][j] = 3;
                    return false;
                }
            } else {  // map[i][j] == 1 or 2 or 3 直接返回false
                return false;
            }
        }
    }
}
