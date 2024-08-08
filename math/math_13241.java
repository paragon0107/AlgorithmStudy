package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_13241 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        if (A < B) {
            long temp = A;
            A = B;
            B = temp;
        }

        long result = A * B / gcd(A, B);
        System.out.println(result);

    }

    private static long gcd(long a, long b) {
        long r = a % b;
        if (r == 0) {
            return b;
        }
        return gcd(b, r);
    }
}
