//STACK USING QUEUE
//IDEA 
//1 TAKE TWO QUEUES Q1 AND Q2 ; IF Q1 IS EMPTY THEN INSERT IN Q1
//1.a REMOVE ELEMENT FROM Q2 AND INSERT IT IN Q1 
//1.b REMOVE ELEMENTS FROM Q1 AND INSERT IT INT Q2
//REPEAR
//POP EFFICIENT APPROACH = push() & pop_effi()
//PUSH EFFICIENT = pop() & push_effi()
class SQ{
  private Queue<Integer> q1=new LinkedList<>();
  private Queue<Integer> q2=new LinkedList<>();
  void push(int x){
    q1.add(x);
    while(!q2.isEmpty()){
      q1.add(q2.remove());
  }
    Queue<Integer> temp_q=q1;
    q1=q2;
    q2=temp_q;
  }
  void pop_effi(){
    if(q2.isEmpty()){
      return;}
    q2.remove();
  }
  
  void push_effi(int x){
    q1.add(x);
  }
  void pop(){
    while(q1.size()>1){
      q2.add(q1.remove());
  }
    q1.remove();
    Queue<Integer> temple_q=q1;
    q1=q2;
    q2=temple_q;
}
// IMPLEMENTING USING ONLY 1 QUEUE
void push_one(int x){
  q1.add(x);
  int len=q1.size();
  while(len>1){
    q1.add(q1.remove());
    len--;
}
}
public class sq_main
  {
    public static void main(String args[])
    {
      SQ  stack=new SQ();
      stack.push(3);
      stack.push(7);
      stack.push(8);
      
    }
  }
