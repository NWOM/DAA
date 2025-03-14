/**
Given an array Arr[] of size T, contains binary digits, where 
0 represents a biker running to the north.

1 represents a biker running to the south.

The task is to count crossing bikers in such a way that each pair of crossing bikers(N, S), where 0<=N<S<T, is passing when N is running to the north and S is running to the south.

Constraints:

0<=N<S<T

Example 1:

Input :

5 -> Number of elements i.e. T

0 -> Value of 1st element.

1 -> Value of 2nd element

0 -> Value of 3rd element.

1 -> Value of 4th element.

1 -> Value of 5th element

Output :

5

Explanation:

The 5 pairs are (Arr[0], Arr[1]), (Arr[0], Arr[3]), (Arr[0], Arr[4]), (Arr[2],Arr[3]) and (Arr[2], Arr[4]).
**/
import java.util.Scanner;

public class BikerCrossing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Read number of elements
        int[] arr = new int[T];

        // Read array input
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // Optimized approach
        int countZeros = 0, crossingPairs = 0;

        for (int i = 0; i < T; i++) {
            if (arr[i] == 0) {
                countZeros++; // Count north-going bikers
            } else {
                crossingPairs += countZeros; // Each '1' pairs with all previous '0's
            }
        }

        System.out.println(crossingPairs);
    }
}
