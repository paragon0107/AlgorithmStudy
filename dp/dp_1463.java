package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[1000001];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 3; i < n; i++) {
            if (i + 1 <= n && dp[i + 1] > dp[i] + 1) {
                dp[i + 1] = dp[i] + 1;
            }
            if (i * 2 <= n && dp[i * 2] > dp[i] + 1) {
                dp[i * 2] = dp[i] + 1;
            }
            if (i * 3 <= n && dp[i * 3] > dp[i] + 1) {
                dp[i * 3] = dp[i] + 1;
            }
        }
        System.out.println(dp[n]);
    }
}
