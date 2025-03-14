import java.util.*;

public class NearestLargerNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int b = sc.nextInt();
        sc.close();

        char[] digits = a.toCharArray();
        Arrays.sort(digits);

        // Convert the smallest permutation to integer
        int c = Integer.parseInt(new String(digits));
        if (c > b) {
            System.out.println(c);
            return;
        }

        // Generate the next permutation until we find a valid one
        do {
            String perm = new String(digits);
            int num = Integer.parseInt(perm);
            if (num > b) {
                System.out.println(num);
                return;
            }
        } while (nextPermutation(digits));

        System.out.println(-1); // If no valid permutation found
    }

    // Function to compute the next lexicographical permutation
    private static boolean nextPermutation(char[] digits) {
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) i--;
        if (i < 0) return false; // No more permutations

        int j = digits.length - 1;
        while (digits[j] <= digits[i]) j--;

        // Swap
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Reverse suffix
        reverse(digits, i + 1, digits.length - 1);
        return true;
    }

    private static void reverse(char[] digits, int left, int right) {
        while (left < right) {
            char temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;
            left++;
            right--;
        }
    }
}
