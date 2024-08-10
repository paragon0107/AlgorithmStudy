package math;

import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_4948 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }
            Boolean[] array = new Boolean[2 * n + 1];
            for(int i = 2 ;i<=2*n;i++){
                array[i] = false;
            }
            int c = 0;
            for (int i = 2; i <= sqrt(2 * n); i++) {
                if (array[i]) {
                    continue;
                }
                for (int j = i + i; j <= (2 * n); j += i) {
                    array[j] = true;
                }
            }
            for(int i = n+1;i<=2*n;i++){
                if(!array[i]) c++;
            }
            System.out.println(c);
        }

    }
}
