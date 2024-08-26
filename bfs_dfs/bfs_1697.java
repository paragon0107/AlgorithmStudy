import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_1697 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int[] visited;
    static int[] graph;
    static Queue<Integer> q;
    static int count;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        bfs(n);
        System.out.println(visited[m] - 1);
    }

    public static void bfs(int n) {
        q = new LinkedList<>();
        visited[n] = 1;

        q.offer(n);

        while (!q.isEmpty()) {
            int a = q.poll();

            int z = a + 1;
            int x = a - 1;
            int c = a * 2;
            check(z, a);
            check(x, a);
            check(c, a);
            count++;
        }
    }

    public static void check(int z, int a) {
        if (z >= 0 && z <= 100000) {
            if(visited[z] == 0){
                q.offer(z);
                visited[z] = visited[a] + 1;
            }
        }
    }
}
