package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bfs_30024 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        PriorityQueue<Corn> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int c = Integer.parseInt(st.nextToken());
                arr[i][j] = c;
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    q.offer(new Corn(i, j, c));
                    visited[i][j] = true;
                }
            }
        }
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            Corn c = q.poll();
            int cx = c.x;
            int cy = c.y;
            sb.append(cx + 1).append(" ").append(cy + 1).append("\n");
            for (int j = 0; j < 4; j++) {
                int nx = cx + dx[j];
                int ny = cy + dy[j];

                if ((nx > 0 && nx < n - 1) && (ny > 0 && ny < m - 1) && !visited[nx][ny]) {
                    q.add(new Corn(nx, ny, arr[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }

        System.out.println(sb);
    }

    public static class Corn implements Comparable<Corn> {
        int x;
        int y;
        int c;

        public Corn(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Corn n) {
            return n.c - this.c;
        }
    }
}
