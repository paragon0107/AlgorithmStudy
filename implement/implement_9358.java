package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_9358 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

                while (n != 2) {
                for (int j = 0; j < (int) Math.ceil(n / 2.0); j++) {
                    arr[j] += arr[n - 1 - j];
                }
                    n = (int) Math.ceil(n / 2.0);
            }
            System.out.print("Case #" + (i + 1) + ": ");
            if (arr[0] > arr[1]) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }

        }
    }
}
