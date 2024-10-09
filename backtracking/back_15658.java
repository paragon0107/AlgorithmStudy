package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_15658 {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[] cal;
    static int n;
    static int total = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        cal = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        total = arr[0];
        dfs(1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            if (total > max) {
                max = total;
            }
            if (total < min) {
                min = total;
            }
            return;
        }

        if (cal[0] > 0) {
            total += arr[depth];
            cal[0]--;
            dfs(depth + 1);
            cal[0]++;
            total -= arr[depth];
        }
        if (cal[1] > 0) {
            total -= arr[depth];
            cal[1]--;
            dfs(depth + 1);
            cal[1]++;
            total += arr[depth];
        }
        if (cal[2] > 0) {
            int temp = total;
            total *= arr[depth];
            cal[2]--;
            dfs(depth + 1);
            cal[2]++;
            total = temp;
        }
        if (cal[3] > 0) {
            int temp = total;
            total /= arr[depth];
            cal[3]--;
            dfs(depth + 1);
            cal[3]++;
            total = temp;
        }

    }
}
