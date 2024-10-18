package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bs_3079 {
    static int n;
    static long m, max;
    static int[] ary;
    static long result = Long.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
            max = Math.max(ary[i], max);
        }

        Arrays.sort(ary);

        bs();

        System.out.println(result);
    }

    public static void bs() {
        long start = 0;
        long end = m * max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (long num : ary) {
                long c = mid / num;

                if (sum >= m) {
                    break;
                }

                sum += c;
            }
            if (sum >= m) {
                end = mid - 1;
                result = Math.min(mid, result);
            } else {
                start = mid + 1;
            }
        }
    }
}
