package com.sagnik.stacks;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    int ptr=-1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size) {
        this.data=new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Nehe Jaga Hai Bhai");
            return false;

        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    public int pop()throws StackException{
        if(isEmpty()){
            throw new StackException("Bhai Khali stack se kya nikalwaoge");
        }
        int remove=data[ptr];
        ptr--;
        return  remove;
    }
    public int peek()throws StackException{
        if(isEmpty()){
            throw new StackException("Ghusa Bhai");
        }
        return data[ptr];
    }

    protected boolean isFull() {
        return ptr==data.length;

    }
    private boolean isEmpty(){
        return ptr==-1;
    }

}
