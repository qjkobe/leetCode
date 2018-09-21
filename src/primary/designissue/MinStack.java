package primary.designissue;

import java.util.NoSuchElementException;

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
public class MinStack {
    private Node top;

    public MinStack() {

    }

    public void push(int x) {
        Node newTop = new Node(x);
        newTop.next = top;
        if (top != null) {
            newTop.minSoFar = newTop.value > top.minSoFar ? top.minSoFar : newTop.value;
        }
        top = newTop;
    }

    public void pop() {
        if (top == null) {
            throw new NoSuchElementException("已经为空");
        }
        top = top.next;
    }

    public int top() {
        if (top == null) {
            throw new NoSuchElementException("已经为空");
        }
        return top.value;
    }

    public int getMin() {
        if (top == null) {
            throw new NoSuchElementException("已经为空");
        }
        return top.minSoFar;
    }

    class Node {
        int value;
        int minSoFar;
        Node next;

        public Node(int x) {
            value = x;
            minSoFar = x;
        }
    }
}
