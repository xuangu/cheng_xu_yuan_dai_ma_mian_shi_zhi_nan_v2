package chapter_1_stackandqueue;

import java.util.Stack;

/*
    题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
    要求：
        1. pop、push、getMin操作的时间复杂度都是O(1)
        2. 设计的栈类型可以使用现成的栈结构
 */
public class Problem_01_GetMinStack {

    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> minData;

        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.minData = new Stack<Integer>();
        }

        public void push(int newNum) {
            this.stackData.push(newNum);

            if (this.minData.isEmpty()) {
                this.minData.push(newNum);
            } else if (newNum < this.minData.peek()) {
                this.minData.push(newNum);
            } else {
                this.minData.push(this.minData.peek());
            }
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            this.minData.pop();
            return this.stackData.pop();
        }

        public int getMin() {
            if (this.minData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.minData.peek();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(12);
        stack.push(2);
        stack.push(12);
        stack.push(4);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

}
