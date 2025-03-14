//Problem: Find the maximum sum of any contiguous subarray of size k
public class FixedSlidingWindow {
    public static int maxSumSlidingWindow(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;

        // Compute the first window sum
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Remove first element, add new one
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSumSlidingWindow(arr, k)); // Output: 9
    }
}

