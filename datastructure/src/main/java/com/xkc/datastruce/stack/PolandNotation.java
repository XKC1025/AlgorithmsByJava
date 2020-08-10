package com.xkc.datastruce.stack;

import java.util.Stack;

/**
 * 逆波兰表达式  后缀表达式
 *
 * @author xukechen
 */
public class PolandNotation {

    public static void main(String[] args) {
        String suffix = "3 4 + 5 * 6 -";
        String[] strings = suffix.split(" ");

        // 从左至右扫描  数字入栈  遇到运算符  弹出栈顶两个元素
        Stack<String> stack = new Stack<>();

        for (String item : strings) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                Integer m = Integer.valueOf(stack.pop());
                Integer n = Integer.valueOf(stack.pop());

                int res = 0;
                // 运算
                switch (item) {
                    case "+":
                        res = m + n;
                        break;
                    case "-":
                        res = n - m;
                        break;
                    case "*":
                        res = m * n;
                        break;
                    case "/":
                        res = n / m;
                        break;
                    default:
                        break;
                }

                // 入栈
                stack.push(Integer.toString(res));
            }
        }
        System.out.println(stack.pop());
    }

}
