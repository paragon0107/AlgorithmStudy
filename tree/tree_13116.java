package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tree_13116 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int r;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            r = 1;
            boolean[] visited = new boolean[1024];
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            while (n >= 1) {
                visited[n] = true;
                n /= 2;
            }
            while (m >= 1) {
                if (visited[m]) {
                    r = m;
                    break;
                }
                m /= 2;
            }
            System.out.println(r * 10);
        }
    }
}

