package data_structure;

public class ArrayQueue {
    int max = 1000;
    int front; // pop 할 때 참조하는 index
    int rear; // push 할 때 참조하는 index
    int[] queue;

    public ArrayQueue() {
        front = rear = 0;
        queue = new int[max];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        if (rear == max - 1) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return rear - front;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Full");
            return;
        }
        queue[rear++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Empty");
            return -1;
        }
        int popValue = queue[front++];
        return popValue;
    }

    public int peek() {
        return queue[front];
    }


}
