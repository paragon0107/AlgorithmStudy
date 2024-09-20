import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_28117 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int c = 0;
        int[] count = new int[80];
        int[] dp = new int[80];

        while (str.contains("longlong")) {
            count[c]++;
            str = str.substring(str.indexOf("longlong") + 4);
            if (!str.startsWith("longlong")) {
                c++;
            }
        }
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 0; count[i] != 0; i++) {
            for (int j = 3; j <= count[i]; j++) {
                if (dp[j] == 0) {
                    dp[j] = dp[j - 1] + dp[j - 2];
                }
            }
        }
        long r = 1;
        for (int i = 0; count[i] != 0; i++) {
            r *= dp[count[i]];
        }
        System.out.println(r);
    }
}
