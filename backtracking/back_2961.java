package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2961 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] ary;
    static boolean[] visit;
    static int limit;
    static int cA = 1;
    static int cB = 0;
    static int n;

    static int minV = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        ary = new int[n][2];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ary[i][0] = Integer.parseInt(st.nextToken());
            ary[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            limit = i;
            back(0);
        }

        System.out.println(minV);
    }

    static void back(int dept) {
        if (dept == limit) {
            minV = Math.min(minV, Math.abs(cA - cB));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                cA *= ary[i][0];
                cB += ary[i][1];
                back(dept + 1);
                cA /= ary[i][0];
                cB -= ary[i][1];
                visit[i] = false;
            }
        }
    }
}
