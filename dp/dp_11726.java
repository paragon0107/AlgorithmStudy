import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_11726 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[] dp = new int[1001];
        st = new StringTokenizer(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 1001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        int n = Integer.parseInt(st.nextToken());
        System.out.println(dp[n]);
    }

}
