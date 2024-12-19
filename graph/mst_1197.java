package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class mst_1197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Node>[] arr;
    static boolean[] visit;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c));
            arr[b].add(new Node(a, c));
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }
        Queue<Node> q = new LinkedList<>();
        q.add(arr[1].get(0));
        int total = arr[1].get(0).cost;

        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < arr[n.dist].size(); i++) {
                if (!visit[arr[n.dist].get(i).dist]) {
                    q.add(arr[n.dist].get(i));
                    total += arr[n.dist].get(i).cost;
                    break;
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int dist;
        int cost;

        public Node(int d, int cost) {
            this.dist = d;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }
}
