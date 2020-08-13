package com.xkc.datastruce.recursion;

/**
 * @author 89804
 */
public class RecursionTest {

    public static void main(String[] args) {
        test(10);
        int factorial = factorial(5);
        System.out.println(factorial);
    }

    private static void test(int n) {
        if (n > 1) {
            test(n - 1);
        }
        System.out.println(n);
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
