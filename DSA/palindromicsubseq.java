public class palindromicsubseq {
    //Java Program to print length of  longest palindromic subsequences in a string
    public static int palindromesubseq(String str,int start,int end){ //recursive approach
        if(start>end) {
            return 0;
        }
        if (start==end) {
            return 1;
        }
        if(str.charAt(start)==str.charAt(end)) {
            return 2 + palindromesubseq(str, start + 1, end - 1);
        }
        return Math.max(palindromesubseq(str,start+1,end),palindromesubseq(str,start,end-1));
    }
    //top-down approach
    public static int topdown(String str,int start,int end,Integer arr[][]){
        if(start>end){
            return 0;
        }
        if(start==end){
            return 1;
        }
        if(arr[start][end]==null){
            if(str.charAt(start)==str.charAt(end)){
                arr[start][end]=2+topdown(str,start+1,end-1,arr);
            }else{
                arr[start][end]=Math.max(topdown(str,start+1,end,arr),topdown(str,start,end-1,arr));
            }
        }
        return arr[start][end];
    }

}
