import java.util.Arrays;
import java.util.Scanner;

public class Covid19Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // Number of elements
        int K = scanner.nextInt();  // The minimum difference required
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Sort the array
        Arrays.sort(A);

        // Binary search for the largest minimum distance
        int left = 0;
        int right = A[N - 1] - A[0];
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceKElements(A, N, K, mid)) {
                result = mid;
                left = mid + 1;  // Try for a larger minimum distance
            } else {
                right = mid - 1;  // Try for a smaller minimum distance
            }
        }

        System.out.println(result);
    }

    public static boolean canPlaceKElements(int[] A, int N, int K, int minDist) {
        int count = 1;  // Start with the first element
        int lastPlaced = A[0];

        for (int i = 1; i < N; i++) {
            if (A[i] - lastPlaced >= minDist) {
                count++;
                lastPlaced = A[i];
                if (count >= K) {
                    return true;  // We successfully placed at least K elements
                }
            }
        }

        return false;  // Not enough elements could be placed
    }
}
