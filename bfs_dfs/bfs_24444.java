package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_24444 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new int[v + 1];

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; graph.size() < e; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(r);

    }

    public static void bfs(int r) {
        Queue<Integer> q = new LinkedList<>();
        int count = 1;

        q.offer(r);
        visited[r] = count++;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i = 0; i < graph.get(a).size(); i++) {
                int n = graph.get(a).get(i);
                if(visited[n] ==0){
                    q.offer(n);
                    visited[n] = count++;
                }
            }
        }
    }
}
