package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_18429 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static boolean[] visit;
    static int n;
    static int k;
    static int total = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back(0);

        System.out.println(count);
    }

    static void back(int depth) {
        if (total < 0) {
            return;
        }
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                total += arr[i] - k;
                back(depth + 1);
                visit[i] = false;
                total -= arr[i] - k;
            }
        }
    }
}
