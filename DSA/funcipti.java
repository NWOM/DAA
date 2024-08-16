import java.util.Arrays;
import java.util.Scanner;

public class funcipti {
    //function optimization
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int[] function =new int[m];
        for(int i=0;i<m;i++){
            function[i]=arr[i];
        }
        int val=function[m-1]-function[0];
        System.out.println(val);
    }
}
