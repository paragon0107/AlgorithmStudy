package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class graph_10282 {
    static int n;
    static int d;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }


            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Node(a, s));
            }

            int[] dist = dijkstra(graph);

            int virusCount = 0;
            int totalSeconds = 0;

            for (int i : dist) {
                if (i != Integer.MAX_VALUE) {
                    virusCount += 1;
                    totalSeconds = Math.max(totalSeconds, i);
                }
            }
            System.out.println(virusCount + " " + totalSeconds);

        }
    }

    private static int[] dijkstra(List<List<Node>> graph) {
        boolean[] computer = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        computer[c] = true;
        dist[c] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(c, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int next = node.next;
            int second = node.second;

            for (int i = 0; i < graph.get(next).size(); i++) {
                Node nextNode = graph.get(next).get(i);

                if (dist[nextNode.next] > second + nextNode.second) {
                    dist[nextNode.next] = second + nextNode.second;
                    queue.add(new Node(nextNode.next, second + nextNode.second));
                }
            }
        }
        return dist;
    }
}

class Node implements Comparable<Node> {
    int next;
    int second;

    public Node(int next, int second) {
        this.next = next;
        this.second = second;
    }

    @Override
    public int compareTo(Node o) {
        return this.second - o.second;
    }
}