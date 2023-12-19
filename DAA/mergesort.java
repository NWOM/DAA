public class mergesort {
    public static void main(String args[]){
        int data[]=new int[]{-2,65,9,87,-1,84,3,2,0};
        mergesort(data,0,data.length-1);
        System.out.println("stop");
    }
    public static void mergesort(int[] data,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            mergesort(data,start,mid);
            mergesort(data,mid+1,end);
            merge(data,start,mid,end);
        }
    }
    public static void merge(int[] data,int start,int mid,int end){
        //build temporary to avoid modifying the original content
        int[] temp=new int[end-start+1];

        int i=start,j=mid+1,k=0;
        //while both of the sub arrays have subvalues then try and merge them in sorted array
        while(i<=mid && j<=end){
            if(data[i]<data[j]){
                temp[k]=data[i];
                i++;
                k++;
            }
            else {
                temp[k]=data[j];
                k++;
                j++;
            }

        }
        //add the rest of the values from the left sub array to the result
        while(i<=mid){
            temp[k]=data[i];
            k++;
            i++;
        }
        while(j<=end){
            temp[k]=data[j];
            k++;
            j++;
        }
              for(i=start;i<=end;i++){
                  data[i]=temp[i-start];
              }

    }
}
