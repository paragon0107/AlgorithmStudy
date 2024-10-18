package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_16493 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[m + 1][n + 1];
        int[][] input = new int[m + 1][2];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int pages = Integer.parseInt(st.nextToken());

            input[i][0] = day;
            input[i][1] = pages;
        }

        for (int i = 1; i <= m; i++) {
            int day = input[i][0];
            int pages = input[i][1];

            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if ((j - day) >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - day] + pages);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
