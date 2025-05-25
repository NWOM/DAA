public class Dstack {
    int capacity = 2;
    int stack[] = new int[capacity];
    int top = 0;

    public void push(int num) {
        if (size() == capacity)
            expand();
        stack[top] = num;
        top++;
    }

    private void expand() {
        int len = size();
        int newStack[] = new int[capacity * 2];
        System.arraycopy(stack, 0, newStack, 0, len);
        stack = newStack;
        capacity *= 2;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        top--;
        int data = stack[top];
        stack[top] = 0;
        shrink();
        return data;
    }

    private void shrink() {
        int length = size();
        if (capacity > 2 && length <= capacity / 4) {
            capacity = capacity / 2;
            int newStack[] = new int[capacity];
            System.arraycopy(stack, 0, newStack, 0, length);
            stack = newStack;
        }
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
