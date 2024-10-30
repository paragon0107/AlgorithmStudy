package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_29615 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] fr = new int[m];
        int[] fri = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            fr[i] = Integer.parseInt(st.nextToken());
        }
        int c =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] == fr[i]&&j>=m) {
                    c++;
                }
            }
        }

        System.out.println(c);
    }
}
