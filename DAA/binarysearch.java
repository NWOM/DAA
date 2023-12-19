import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class binarysearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1; // Not found
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the size of the array:");
        int size = Integer.parseInt(br.readLine());

        int[] sortedArray = new int[size];

        System.out.println("Enter the sorted elements of the array separated by spaces:");

        String[] elements = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            sortedArray[i] = Integer.parseInt(elements[i]);
        }

        Arrays.sort(sortedArray); // Sorting the array for binary search

        System.out.println("Enter the element to search:");
        int target = Integer.parseInt(br.readLine());

        int result = binarySearch(sortedArray, target);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the array");
        }

        br.close();
    }
}
