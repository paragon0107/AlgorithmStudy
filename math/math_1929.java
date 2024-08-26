package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_1929 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        boolean[] array = new boolean[A+1];

        for(int i = 2; i <= A; i++) {
            if(array[i]) continue;

            if(i >= B) sb.append(i).append('\n');

            for(int j = i + i; j <= A; j += i) {
                array[j] = true;
            }
        }

        System.out.println(sb);

    }
}
