package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_25418 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[1000001];
        for (int i = 1; i < 1000001; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[a] = 0;
        for (int i = a; i < k; i++) {
            if (i + 1 <= 1000001 && dp[i + 1] > dp[i] + 1) {
                dp[i + 1] = dp[i] + 1;
            }
            if (i * 2 <= 1000001 && dp[i * 2] > dp[i] + 1) {
                dp[i * 2] = dp[i] + 1;
            }
        }
        System.out.println(dp[k]);
    }
}
