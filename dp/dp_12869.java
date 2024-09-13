package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dp_12869 {
    public static int[] scv;
    public static boolean[][][] visited = new boolean[61][61][61];
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        scv = new int[3];
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i < 3; i++) {
            scv[i] = 0;
        }
        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];

        dfs(s1, s2, s3, 0);
        System.out.println(result);
    }

    public static void dfs(int a, int b, int c, int count) {
        a = Math.max(0, a);
        b = Math.max(0, b);
        c = Math.max(0, c);

        if (a == 0 & b == 0 && c == 0) {
            result = Math.min(result, count);
            return;
        }

        int[] sorting = {a, b, c};
        Arrays.sort(sorting);
        c = sorting[0];
        b = sorting[1];
        a = sorting[2];

        if (visited[a][b][c]) {
            return;
        } else {
            visited[a][b][c] = true;
        }

        if (result < count) {
            return;
        }

        dfs(a - 9, b - 3, c - 1, count + 1);
        dfs(a - 9, b - 1, c - 3, count + 1);
        dfs(a - 3, b - 9, c - 1, count + 1);
        dfs(a - 3, b - 1, c - 9, count + 1);
        dfs(a - 1, b - 9, c - 3, count + 1);
        dfs(a - 1, b - 3, c - 9, count + 1);
    }
}
