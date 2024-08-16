import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//reverse first k element in a queue
public class Reversequeue {
    public Queue<Integer> modifyQueue(Queue<Integer> q,int k){
        if (q == null || k <= 0 || k > q.size()) {
            return q;
        }
        Stack<Integer> stack=new Stack<>();
        int n=q.size();
        for(int i=0;i<k;i++){
            stack.push(q.peek());
            q.poll();
        }
        for(int i=0;i<k;i++){
            q.add(stack.peek());
            stack.pop();
        }
        for(int i=0;i<n-k;i++){
            int b=q.peek();
            q.add(b);
            q.poll();
        }
        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        int k = 3;

        Reversequeue rq=new Reversequeue();
        Queue<Integer> result = rq.modifyQueue(q, k);

        System.out.println("Modified queue: " + result);
    }
}
