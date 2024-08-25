package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_10610 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        int[] ary = new int[10];
        long total = 0;

        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt(s.substring(i, i + 1));
            total += n;
            ary[n] += 1;
        }

        if (!s.contains("0") || total % 3 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 9; i >= 0; i--) {
            while (ary[i]>0){
                sb.append(i);
                ary[i]--;
            }
        }
        System.out.println(sb);
    }
}
