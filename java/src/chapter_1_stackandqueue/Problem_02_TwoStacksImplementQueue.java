package chapter_1_stackandqueue;

import java.util.Stack;

/*
    题目：用两个栈实现队列，支持队列的基本操作(add、poll、peek)
*/
public class Problem_02_TwoStacksImplementQueue {

    public static class MyQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public MyQueue() {
            this.pushStack = new Stack<Integer>();
            this.popStack = new Stack<Integer>();
        }

        public void add(int value) {
            this.pushStack.push(value);
        }

        public int poll() {
            if (!this.popStack.empty()) {
                return this.popStack.pop();
            }
            if (this.pushStack.empty()) {
                throw new RuntimeException("队列空");
            }
            pushToPop();
            return this.popStack.pop();
        }

        public int peek() {
            if (!this.popStack.empty()) {
                return this.popStack.peek();
            }
            if (this.pushStack.empty()) {
                throw new RuntimeException("队列空");
            }
            pushToPop();
            return this.popStack.peek();
        }

        private void pushToPop() {
            if (!this.popStack.empty()) {
                return;
            }

            while (!this.pushStack.empty()) {
                this.popStack.push(this.pushStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.peek());
        queue.poll();
        queue.poll();
        System.out.println(queue.peek());

        queue.add(5);
        queue.poll();
        queue.poll();
        System.out.println(queue.peek());

    }

}
