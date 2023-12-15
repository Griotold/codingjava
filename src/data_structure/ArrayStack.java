package data_structure;

public class ArrayStack {
    int top; // 인덱스
    int size; // 스택의 크기
    int[] stack;

    public ArrayStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int item) {
        stack[++top] = item;
    }

    public int pop() {
        int pop = stack[top];
        stack[top--] = 0;
        return pop;
    }

    public int peek() {
        return stack[top];
    }

    public int search(int target) {
        int count = 0;
        for (int i = top; i >= 0; i--) {
            if (stack[i] == target) {
                return top; // 찾은 요소의 위치를 반환
            }
        }
        return -1; // 찾지 못한 경우 -1 반환
    }


    public boolean isEmpty() {
        return top == -1; // top이 -1이면 스택이 비어있는 것으로 판단
    }
}
