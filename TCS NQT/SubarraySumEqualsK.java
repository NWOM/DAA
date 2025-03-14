//subarray sum equal to K 
import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);  // Base case: A sum of 0 appears once (empty subarray)

        for (int num : nums) {
            prefixSum += num;
            
            // Check if there is a subarray that sums to k
            if (prefixSumFreq.containsKey(prefixSum - k)) {
                count += prefixSumFreq.get(prefixSum - k);
            }

            // Update the frequency of the current prefixSum
            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));  // Output: 2
    }
}
