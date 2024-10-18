package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_17175 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[51];
        dp[0] = 1;
        dp[1] = 1;

        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++) {
            dp[i] = (1 + dp[i-1] + dp[i-2]) % 1000000007;
        }

        System.out.print(dp[n]);
    }
}
