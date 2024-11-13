import java.io.*;
public class fenwickTree
  {
    static int[] farr;
    public static void main(String args[])throws IOException, NumberFormatException{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int N=Integer.parseInt(br.readLine());
      int arr[]=new int[N+1];
      String st[]=br.readLine().split(" ");
      for(int i=1;i<=N;i++){
        arr[i]=Integer.parseInt(st[i-1]);
      }
      fenwickTree(arr);
      int Q=Integer.parseInt(br.readLine());
      for(int i=0;i<Q;i++){
        st=br.readLine().split(" ");
        if(st[0].equals("q")){
          int val=query(Integer.parseInt(st[1]),Integer.parseInt(st[2]));
          System.out.println(val);
        }else{
          update(Integer.parseInt(st[1]),Integer.parseInt(st[2]));
        }
      }
    }
    public static void fenwickTree(int[] arr){
      farr=new int[arr.length];
      for(int i=1;i<arr.length;i++){
        update(i,arr[i]);
      }
    }
    public static int query(int L,int R){
      return prefixSum(R)-prefixSum(L-1);
    }
    public static int prefixSum(int idx){
      int sum=0;
      while(idx>0){
        sum+=farr[idx];
        idx = idx - ( idx & (-idx) );
      }
      return sum;
    }
    public static void update(int idx,int delta) {
      while(idx<farr.length){
        farr[idx]+=delta;
        idx=idx+(idx&-idx);
    }
  }
  }
