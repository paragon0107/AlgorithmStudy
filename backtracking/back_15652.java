import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_15652 {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m + 1];
        visit = new boolean[m + 1];
        dfs(1);
        System.out.println(sb);

    }

    public static void dfs(int depth) {
        if (depth == m+1) {
            for (int i = 1; i <= m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[depth - 1] <= i) {
                arr[depth] = i;
                dfs(depth + 1);
            }
        }
    }
}
