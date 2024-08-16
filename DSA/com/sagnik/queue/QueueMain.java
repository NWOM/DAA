package com.sagnik.queue;

public class QueueMain {
    public static void main(String[] args)throws Exception {
        CustomQueue queue=new CustomQueue(5);
        queue.insert(10);
        queue.insert(12);
        queue.insert(7);
        queue.insert(9);
        queue.insert(8);
        queue.display();
        System.out.print(queue.remove()+"\n");
        queue.display();
    }
}
