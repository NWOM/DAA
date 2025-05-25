//Custom Stack implementation in JAVA using array of fixed length
public class Stack {
    int stack[] = new int[5];
    int top = 0;

    public void push(int data) {
        if (top == stack.length) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[top] = data;
        top++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1; // Or throw exception
        }
        top--;
        int data = stack[top];
        stack[top] = 0;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top <= 0;
    }

    public void show() {
        for (int i = 0; i < top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

