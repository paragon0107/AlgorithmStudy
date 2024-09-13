package cumulativeSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sum_16139 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int[][] alpha = new int[26][s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            int c = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                alpha[j][i] = alpha[j][i - 1];
                if (c == j) {
                    alpha[j][i] = alpha[j][i - 1] + 1;
                }
            }
        }

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            int c = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            bw.write((alpha[c][end] - alpha[c][start - 1]) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
