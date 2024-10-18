package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_11052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] ary = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                ary[i] = Math.max(ary[i], ary[i - j] + ary[j]);
            }
        }
        System.out.println(ary[n]);

    }
}

