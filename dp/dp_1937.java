import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dp_1937 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][] ary;
    static int[][] visited;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        ary = new int[n][n];
        visited = new int[n][n];
        int tMax = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = dfs(i, j);
                if(tMax < v){
                    tMax = v;
                }
            }
        }

        System.out.println(tMax);
    }

    public static int dfs(int x, int y) {
        if(visited[x][y] > 0){
            return visited[x][y];
        }
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n) && (ary[nx][ny] > ary[x][y])) {
                if (visited[nx][ny] == 0) {
                    int nv = dfs(nx, ny) + 1;
                    if (max < nv) {
                        max = nv;
                    }
                } else {
                    if (max < visited[nx][ny] + 1) {
                        max = visited[nx][ny] + 1;
                    }
                }
            }
        }
        visited[x][y] = max;
        return max;
    }

}
