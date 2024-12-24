//O(log N)
public Solution
{
  public int peakElement(int[] nums)
  {
    if(nums.length == 1 || nums[0]>nums[1]){
      return 1;
    }
    if(nums[nums.length-1] > nums[nums.length-2]){ return nums.length-1; }
    int startIndex=1;
    int endIndex=nums.length-2;
    while(startIndex<=endIndex)
      {
        int mid=startIndex + (endIndex-startIndex)/2;
        if(nums[mid] > nums[mid-1] && nums[mid]>nums[mid+1]){
          return mid;
        }
        else if(nums[mid]<nums[mid-1]){
          endIndex=mid-1;
      }else if(nums[mid]<nums[mid+1]){
          startIndex=mid+1;
        }
  }
}
