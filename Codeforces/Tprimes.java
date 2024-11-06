import java.util.Scanner;

public class Tprimes {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        long[] list = new long[n];
        for (int i = 0; i < n; i++) {
            list[i] = in.nextLong();
        }

        for (int i = 0; i < n; i++) {
            long number = list[i];
            long sqrt = (long) Math.sqrt(number);

             // Check if number is a perfect square and sqrt is a prime number
            //  If a Number has Exactly three individual divisors it needs to be in the form
            //   N=p^2 {WHERE P IS PRIME }
            if (sqrt * sqrt == number && isPrime(sqrt)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}
