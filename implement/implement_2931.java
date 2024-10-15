import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class implement_2931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0}; // 위,아래,왼쪽,오른쪽
    static int[] dy = {0, 0, -1, 1};
    static char[][] ary;
    static boolean[][] visited;
    static int r;
    static int c;
    static int[] z = new int[2];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ary = new char[r][c];
        visited = new boolean[r][c];
        int[] m = new int[2];


        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                char input = s.charAt(j);
                if (input == 'm') {
                    m[0] = i;
                    m[1] = j;
                }
                ary[r][c] = input;
            }
        }
        dfs(m[0], m[1]);
        bfs(z[0], z[1]);
    }

    public static void dfs(int x, int y) {
        boolean check = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((nx >= 0 && nx < r) && (ny >= 0 && ny < c) && (ary[nx][ny] != '.') && (!visited[nx][ny])) {
                visited[nx][ny] = true;
                check = true;
                dfs(nx, ny);
            }
        }
        if (!check) {
            z[0] = x;
            z[1] = y;
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int cx = pos[0];
            int cy = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!visited[nx][ny] && ary[nx][ny] != '.') {

                }

                if ((nx >= 0 && nx < r) && (ny >= 0 && ny < c) && (!visited[nx][ny])) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
