package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bs_26168 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Long> arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 1 || k == 2) {
                long target = Long.parseLong(st.nextToken());
                int index = binarySearch(target, k);
                sb.append(n - index).append("\n");
            }
            if (k == 3) {
                long target1 = Long.parseLong(st.nextToken());
                long target2 = Long.parseLong(st.nextToken());
                int index1 = binarySearch(target1, 1);
                int index2 = binarySearch(target2, 2);
                sb.append(index2 - index1).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static int binarySearch(long key, int method) {
        int start = 0;
        int end = n;
        while (start < end) {
            int mid = (start + end) / 2;
            if (method == 1) {
                if (arr.get(mid) >= key) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else if (method == 2) {
                if (arr.get(mid) > key) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return start;
    }
}
