
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_1934 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A < B) {
                int temp = A;
                A = B;
                B = temp;
            }

            int result = A * B / gcd(A, B);
            System.out.println(result);
        }
    }

    private static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return gcd(b, r);
    }
}
