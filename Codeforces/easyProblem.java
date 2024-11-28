import java.util.*;
//https://codeforces.com/problemset/problem/1096/D
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of characters in the string
        String s = sc.next(); // Input string
        int[] cost = new int[n]; // Array to store the cost of each character

        // Reading the cost array
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        // Initialize variables for 'h', 'a', 'r', 'd'
        long a = 0, b = 0, c = 0, d = 0;

        // Traverse the string and calculate minimum costs
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'h') {
                a += cost[i]; // Add the cost for 'h'
            } else if (ch == 'a') {
                b = Math.min(a, b + cost[i]); // Minimize the cost for 'a'
            } else if (ch == 'r') {
                c = Math.min(b, c + cost[i]); // Minimize the cost for 'r'
            } else if (ch == 'd') {
                d = Math.min(c, d + cost[i]); // Minimize the cost for 'd'
            }
        }

        // The result is the minimum cost to avoid forming "hard"
        System.out.println(d);
    }
}
