package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_16173 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

        if (visited[n - 1][n - 1]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    public static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();

            int nx = tmp[0] + graph[tmp[0]][tmp[1]];
            int ny = tmp[1];
            visit(nx,ny);

            nx = tmp[0];
            ny = tmp[1] + graph[tmp[0]][tmp[1]];
            visit(nx,ny);
        }
    }
    public static void visit(int nx, int ny){
        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}