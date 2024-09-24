import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bs_2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] ary;
    static int m;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ary = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
            if (max < ary[i]) {
                max = ary[i];
            }
        }
        System.out.println(bs());

    }

    public static int bs() {
        int min = 0;
        int mid = -1;
        while (min < max) {
            mid = (max + min) / 2;
            long total = 0;
            for (int n : ary) {
                if (n > mid) {
                    total += n - mid;
                }
            }
            if (total < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min -1;
    }
}
