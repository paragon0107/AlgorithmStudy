package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_dfs_1260 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] bfs_visited;
    static int[] dfs_visited;

    static int bfs_count = 1;
    static int dfs_count = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        dfs_visited = new int[n + 1];
        bfs_visited = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (ArrayList<Integer> node : graph) {
            Collections.sort(node);
        }

        dfs(v);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);

    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(v);
        bfs_visited[v] = bfs_count;

        while (!q.isEmpty()) {
            int n = q.poll();
            sb.append(n).append(" ");
            for (int i = 0; i < graph.get(n).size(); i++) {
                int nn = graph.get(n).get(i);
                if (bfs_visited[nn] != 0) {
                    continue;
                }
                q.offer(nn);
                bfs_visited[nn] = bfs_count++;
            }
        }
    }

    public static void dfs(int v) {
        dfs_visited[v] = dfs_count;
        sb.append(v).append(" ");
        for (int i = 0; i < graph.get(v).size(); i++) {
            int n = graph.get(v).get(i);

            if (dfs_visited[n] != 0) {
                continue;
            }
            dfs_count++;
            dfs(n);
        }
    }
}
