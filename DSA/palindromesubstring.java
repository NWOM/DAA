public class palindromesubstring
{
    private static int recursivesubsrting(String str,int start,int end){
        if(start>end){
            return 0;
        }
        if(start==end){
            return 1;
        }
        if(str.charAt(start)==str.charAt(end)){
            int length=end-start-1;
            if(length==recursivesubsrting(str,start+1,end-1)){
                return 2+length;
            }
        }
        return Math.max(recursivesubsrting(str,start+1,end),recursivesubsrting(str,start,end-1));
    }
    //top-down approach
    private static int topdown(String str,int start,int end,Integer arr[][]){
        if(start>end){
            return 0;
        }
        if(start==end){
            return 1;
        }
        if(arr[start][end]==null){
            if(str.charAt(start)==str.charAt(end)){
               int length=end-start-1;
               if(length==topdown(str,start-1,end+1,arr)){
                   arr[start][end]=2+length;
               }
            }else{
                arr[start][end]=Math.max(topdown(str,start+1,end,arr),topdown(str,start,end-1,arr));
            }
        }
        return arr[start][end];
    }
}
