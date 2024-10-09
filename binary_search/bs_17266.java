package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bs_17266 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] Arr;
    static int N,M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        Arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(possible(mid)) {
                result = mid;
                right = mid - 1;
            }
                       else
                left = mid + 1;
        }
        System.out.println(result);
    }

    static boolean possible(int target) {
        int prev = 0;
        for(int i = 0; i < Arr.length; i++) {

            if(Arr[i] - target <= prev) {
                prev = Arr[i] + target;
                            } else { return false; }

        }

        return N - prev <= 0;
    }
}
