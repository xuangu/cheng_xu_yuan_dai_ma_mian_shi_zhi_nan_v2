package chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 题目：仅使用递归函数实现栈中元素的反转
 */
public class Problem_03_ReverseStackUsingRecursive {

    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }

        int bottomValue = getAndRemoveBottomValue(stack);
        reverse(stack);
        stack.push(bottomValue);
    }

    public static int getAndRemoveBottomValue(Stack<Integer> stack) {
        if (stack.empty()) {
            throw new RuntimeException("error");
        }

        int popValue = stack.pop();
        if (stack.empty()) {
            return popValue;
        }

        int bottomValue = getAndRemoveBottomValue(stack);
        stack.push(popValue);

        return bottomValue;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(4);
        stack.push(4);

        reverse(stack);

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
