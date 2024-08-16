package com.sagnik.trees;

public class SegmentTree {
    public static void main(String[] args) {
        int[]arr={6,7,-2,9,13,5,8,};
        SegmentTree tree=new SegmentTree(arr);
    }
    private static class Node{
        int data;
        int startingIndex;
        int endingIndex;
        Node left;
        Node right;
        public Node(int startingIndex,int endingIndex){
            this.startingIndex=startingIndex;
            this.endingIndex=endingIndex;
        }

    }
    Node root;
    public SegmentTree(int[] arr){
        //create a tree using an array
        this.root=constructTree(arr,0,arr.length-1);
    }
    private Node constructTree(int[] arr,int start,int end){
        if(start==end){
            //leaf node
            Node leaf=new Node(start,end);
            leaf.data=arr[start];
            return leaf;
        }
        //create new node with index you are at
        Node node=new Node(start,end);
        int mid=(start+end)/2;
        node.left=this.constructTree(arr,start,mid);
        node.right=this.constructTree(arr,mid+1,end);
        node.data=node.left.data+node.right.data;
        return node;
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str="";
        if(node.left!=null){
            str+="Interval=["+node.left.startingIndex+node.left.endingIndex+"] and date"+node.left.data+  "+->";

        }else{
            str=str+"No left child";
        }
        //for current node
        if(node.right!=null) {
            str += "Interval=[" + node.right.startingIndex + node.right.endingIndex + "] and date" + node.right.data + "+->";
        }else{
            str+="No right child";
        }
    }
}
