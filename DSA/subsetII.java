import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class subsetII {
    static class pair{
        int i;
        int j;
        String psf;
        public pair(int i,int j,String psf){
            this.psf=psf;
            this.i=i;
            this.j=j;
        }
    }
    public static void main(String args[])throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enteer the number of terms");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        boolean dp[][]=new boolean[arr.length+1][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                } else if (i==0) {
                    dp[i][j]=false;
                } else if (j==0) {
                    dp[i][j]=true;
                }else{
                    if(dp[i - 1][j]){
                        dp[i][j]=true;
                    }
                    else{
                        if(j>=arr[i-1]){
                            if(dp[i - 1][j - arr[i - 1]]){
                                dp[i][j]=true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][target]);
        ArrayDeque<pair> queue=new ArrayDeque<>();
        queue.add(new pair(n,target,""));
        while(queue.size()>0){
            pair rem=queue.removeFirst();
            if(rem.i==0 && rem.j==0){
                System.out.println(rem.psf);

            }else {
                boolean exclude = dp[rem.i - 1][rem.j];
                if (exclude) {
                    queue.add(new pair(rem.i - 1, rem.j, rem.psf));
                }
                if (rem.j > arr[rem.i - 1]) {
                    boolean include = dp[rem.i - 1][rem.j - arr[rem.i - 1]];
                    if (include) {
                        queue.add(new pair(rem.i - 1, rem.j - arr[rem.i - 1], rem.psf +" "+ (rem.i - 1)));//print indices
                    }
                }
            }

        }
    }
}
