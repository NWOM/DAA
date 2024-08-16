package com.sagnik.stacks;

public class StackMain {
    public static void main(String[] args) throws StackException
    {
        DynamicStack stack=new DynamicStack(5);
        stack.push(54);
        stack.push(61);
        stack.push(56);
        stack.push(590);
        stack.push(8898);
        stack.push(678);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
