import java.util.*;
import java.io.*;
//Longest Increasing Consecutive Subsequence
//https://codeforces.com/contest/977/problem/F
public class Main {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int N = 200020; 
    static int ans = 0, curr = 0;
    static int testCases;
    static long[] Arr = new long[N];
    static Set<Integer> set = new HashSet<>();
    static Map<Long, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        testCases = in.nextInt(); 
        for (int i = 0; i < testCases; i++) {
            Arr[i] = in.nextLong(); 
            hashMap.put(Arr[i], Math.max(hashMap.getOrDefault(Arr[i], 0),
                    hashMap.getOrDefault(Arr[i] - 1, 0) + 1));
            if (hashMap.get(Arr[i]) > ans) {
                ans = hashMap.get(Arr[i]);
                curr = (int) Arr[i]; 
            }
        }

        System.out.println(ans);
        
        for (int i = testCases - 1; i >= 0; i--) {
            if (Arr[i] == curr) {
                curr--;
                set.add(i);
            }
        }

       
        List<Integer> indices = new ArrayList<>(set);
        Collections.sort(indices);
        for (int i : indices) {
            System.out.print((i + 1) + " "); 
        }
        System.out.println();
        out.flush(); 
    }
}
