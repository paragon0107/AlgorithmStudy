package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class dfs_24479 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static int count;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        check = new int[v + 1];

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i < e; i++) {
            Collections.sort(graph.get(i));
        }

        count =1;

        dfs(s);

    }


    public static void dfs(int vertex){
        check[vertex] = count;

        for (int i =0;i<graph.get(vertex).size();i++){
            int n = graph.get(vertex).get(i);

            if (check[n] == 0){
                count++;
                dfs(n);
            }
        }
    }
}
