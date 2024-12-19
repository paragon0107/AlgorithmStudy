package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class graph_1967 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited;
    static int n;

    static ArrayList<Node>[] list;
    static int max = 0;
    static int max_idx = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y, c));
            list[y].add(new Node(x, c));
        }
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(max);
    }

    public static void dfs(int idx, int cnt) {
        if (max < cnt) {
            max = cnt;
            max_idx = idx;
        }
        for (Node a : list[idx]) {
            if (!visited[a.idx]) {
                visited[a.idx] = true;
                dfs(a.idx, cnt + a.cnt);
            }
        }
    }

    static class Node {
        int idx, cnt;

        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}