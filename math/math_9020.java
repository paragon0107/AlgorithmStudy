package math;

import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_9020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        Boolean[] array = new Boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            array[i] = true;
        }
        for (int i = 2; i <= sqrt(10000); i++) {
            if (array[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    array[j] = false;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int a = n / 2;
            int b = n / 2;

            while (true) {
                if (array[a] && array[b] && a + b == n) {
                    System.out.println(a + " " + b);
                    break;
                }
                a--;
                b++;
            }
        }
    }
}
