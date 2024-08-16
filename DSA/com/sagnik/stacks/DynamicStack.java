package com.sagnik.stacks;

public class DynamicStack extends CustomStack {
    public DynamicStack(){
        super(); //it will call CustomStack()
    }
    public DynamicStack(int size){
        super(size);
    }
    @Override
    public boolean push(int item){
        //this take care of it being pull
        if(this.isFull()){
            //double the array size
            int[] temp=new int[data.length*2];
            //copy all prev items in new data
            for(int i=0;i< data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
        //insert item
        // at this point we know that array is not  full
        return super.push(item);
    }
}
