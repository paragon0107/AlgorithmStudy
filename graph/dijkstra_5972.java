package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dijkstra_5972 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Node>[] arr;
    static int[] dist;
    static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        dist = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c));
            arr[b].add(new Node(a, c));
        }

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (Node next : arr[now.d]) {
                if (dist[next.d] > dist[now.d] + next.cost) {
                    dist[next.d] = dist[now.d] + next.cost;
                    q.offer(new Node(next.d, dist[next.d]));
                }
            }
        }

        System.out.println(dist[n]);
    }

    public static class Node implements Comparable<Node> {
        int d;
        int cost;

        public Node(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
