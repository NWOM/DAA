//ROTATE ARRAY BY K POSITION
import java.util.*;

public class RotateCyclical {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Read N
        int N = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Read array as a comma-separated string
        String input = sc.nextLine();
        String[] inputArr = input.split(",");

        // Read K
        int K = sc.nextInt();

        // Convert string array to int array
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputArr[i].trim());
        }

        // Print result
        int[] rotatedArr = rotateCyclical(arr, N, K);
        System.out.println(Arrays.toString(rotatedArr));

        sc.close();
    }

    private static int[] rotateCyclical(int[] arr, int N, int K) {
        int n = arr.length;
        K = K % n; // Normalize K if greater than array length

        int[] result = new int[n];

        // Copy last K elements to the beginning
        System.arraycopy(arr, n - K, result, 0, K);

        // Copy first (n-K) elements to the end
        System.arraycopy(arr, 0, result, K, n - K);

        return result;
    }
}
