import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_2502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[31];

        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int b = k / dp[d - 1] / 2 - 1;

        for (int i = b; i < k / dp[d - 1]; i++) {
            for (int j = b; j > 0; j--) {
                if (dp[d - 1] * j + dp[d] * i == k) {
                    dp[1] = j;
                    dp[2] = i;
                }
            }
            if (dp[1] != 0) {
                break;
            }
        }
        sb.append(dp[1]).append("\n").append(dp[2]);
        System.out.println(sb);
    }
}
