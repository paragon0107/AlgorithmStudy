package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_16943 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[] ary;
    static int length;
    static char[] s;
    static int max = -1;
    static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String v = st.nextToken();
        n = Integer.parseInt(st.nextToken());
        ary = v.toCharArray();
        length = ary.length;
        s = new char[length];
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        if (depth == length) {
            StringBuilder sb = new StringBuilder();
            if (s.length > ary.length) {
                return;
            }
            if (s[0] == '0') {
                return;
            }
            for (char c : s) {
                sb.append(c);
            }
            int result = Integer.parseInt(sb.toString());
            if (result < n && result > max) {
                max = result;
            }
            return;
        }
        for (int i = depth; i < length; i++) {
            char c = ary[depth];
            ary[depth] = ary[i];
            ary[i] = c;
            s[depth] = ary[depth];
            dfs(depth + 1);
            ary[i] = ary[depth];
            ary[depth] = c;
        }
    }
}
