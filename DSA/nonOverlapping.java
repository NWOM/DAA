import java.util.Scanner;

public class nonOverlapping {
    //Maximum sum of two non overlapping sub array
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int x=sc.nextInt();
        int y=sc.nextInt();
        System.out.println(solution(arr,x,y));
    }
    private static int solution(int[] arr,int x,int y){
        int n= arr.length;
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            if(i<x){
                sum+=arr[i];
                dp1[i]=sum;
            }else{
                sum +=arr[i]+arr[i-x];
                dp1[i]=Math.max(dp1[i-1],sum);
            }
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            if(i+y>=n){
                sum+=arr[i];
                dp2[i]=sum;
            }else{
                sum += arr[i]-arr[i+y];
                dp2[i]=Math.max(dp2[i+1],sum);
            }
        }
        int ans=0;
        for(int i=x-1;i<n-y;i++){
            ans=Math.max(ans,dp1[i]+dp2[i+1]);
        }
        dp1=new int[n];
        dp2=new int[n];
       sum=0;
        for(int i=0;i<n;i++){
            if(i<y){
                sum+=arr[i];
                dp1[i]=sum;
            }else{
                sum +=arr[i]+arr[i-y];
                dp1[i]=Math.max(dp1[i-1],sum);
            }
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            if(i+x>=n){
                sum+=arr[i];
                dp2[i]=sum;
            }else{
                sum += arr[i]-arr[i+x];
                dp2[i]=Math.max(dp2[i+1],sum);
            }
        }

        for(int i=y-1;i<n-x;i++){
            ans=Math.max(ans,dp1[i]+dp2[i+1]);
        }
        return  ans;
    }
}
