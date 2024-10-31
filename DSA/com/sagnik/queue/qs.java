import java.util.Stack;

class qs {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    public void enqueue(int x) {
        s1.push(x);
        System.out.println("Enqueued: " + x);
    }
    public Integer dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) {
            System.out.println("Queue is empty");
            return null; 
        }
        Integer dequeuedElement = s2.pop();
        System.out.println("Dequeued: " + dequeuedElement);
        return dequeuedElement;
    }
        public void display() {
        System.out.print("Current queue: ");
        Stack<Integer> temp = new Stack<>();
        while (!s2.isEmpty()) {
            int element = s2.pop();
            System.out.print(element + " ");
            temp.push(element); 
        }
        while (!temp.isEmpty()) {
            s2.push(temp.pop());
        }
        while (!s1.isEmpty()) {
            int element = s1.pop();
            System.out.print(element + " ");
            temp.push(element); 
        }
        while (!temp.isEmpty()) {
            s1.push(temp.pop());
        }
        System.out.println();
    }
}

public class qs_main {
    public static void main(String args[]) {
        qs queue = new qs();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.display();
        queue.dequeue(); 
        queue.display(); 

        queue.dequeue(); 
        queue.display(); 

        queue.dequeue();
        queue.display();

        queue.dequeue();
    }
}
