package data_structure;

public class ArrayStackMain {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        System.out.println(arrayStack.size);
        arrayStack.push(30);
        arrayStack.push(40);
        arrayStack.push(50);
        int search = arrayStack.search(50);
        System.out.println(search);
    }
}
