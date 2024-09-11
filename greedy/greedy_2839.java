import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_2839 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[5001];
        for (int i = 0; i <= 5000; i++) {
            dp[i] = -1;
        }
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (dp[i - 3] > 0) {
                dp[i] = dp[i - 3] + 1;
            }
            if (dp[i - 5] > 0) {

                dp[i] = dp[i - 5] + 1;

            }
        }

        System.out.println(dp[n]);
    }
}
