package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;

    static int[] huddle = new int[101];
    static int[] ary = new int[101];

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i < huddle.length; i++) {
            huddle[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            huddle[a] = b;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            huddle[a] = b;
        }


        System.out.println(bfs(1));

    }

    private static int bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        ary[s] = 0;

        while (true) {
            int c = q.poll();
            for (int i = 1; i < 7; i++) {
                int nc = c + i;
                if (nc <= 100 && ary[huddle[nc]] == 0) {
                    q.add(huddle[nc]);
                    ary[huddle[nc]] = ary[c] + 1;
                    if (huddle[nc] == 100) {
                        return ary[100];
                    }
                }
            }
        }
    }
}
