package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] ary;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        ary = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ary[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int cx = pos[0];
            int cy = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m) && ary[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    ary[nx][ny] = ary[cx][cy] + 1;
                }
            }
        }
        int max = 1;
        boolean full = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ary[i][j] > max) {
                    max = ary[i][j];
                }
                if (ary[i][j] == 0) {
                    full = false;
                }
            }
        }

        if (full) {
            System.out.println(max - 1);
        } else {
            System.out.println(-1);
        }
    }
}
