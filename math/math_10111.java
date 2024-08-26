package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_10111 {
    /*
     * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
     * 1 2 3 3 4 4 5 5 5
     * 1     0 1                     1
     * 2     0 1 2                   1 1
     * 3     0 1 2 3                 1 1 1
     * 4     0 1 3 4                 1 2 1       2
     * 5     0 1 3 4 5               1 2 1 1
     * 6     0 1 3 5 6               1 2 2 1----- 2.5
     * 7     0 1 3 5 6 7             1 2 2 1 1
     * 8     0 1 3 5 7 8             1 2 2 2 1
     * 9     0 1 3 6 8 9             1 2 3 2 1------- n + n-1   3
     * 10    0 1 3 6 8 9 10          1 2 3 2 1 1
     * 11    0 1 3 6 8 10 11         1 2 3 2 2 1
     * 12    0 1 3 6 9 11 12         1 2 3 3 2 1   ------2* n     3.4
     * 13    0 1 3 6 9 11 12 13      1 2 3 3 2 1 1-------2*n + 1   3.6
     * 14    0 1 3 6 9 11 13 14      1 2 3 3 2 2 1
     * 15    0 1 3 6 9 12 14 15      1 2 3 3 3 2 1
     * 16    0 1 3 6 10 13 15 16     1 2 3 4 3 2 1--------- n + n-1    4
     * 17    0 1 3 6 10 13 15 16 17  1 2 3 4 3 2 1 1
     * 18    0 1 3 6 10 13 15 17 18  1 2 3 4 3 2 2 1
     * 19    0 1 3 6 10 13 16 18 19  1 2 3 4 3 3 2 1
     * 20    0 1 3 6 10 14 17 19 20  1 2 3 4 4 3 2 1----------
     * 21    0 1 3 6 10 14 17 19 20 21   1 2 3 4 4 3 2 1 1
     * */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            double v = Math.sqrt(to - from);
            int uv = (int) Math.ceil(v);
            int dv = (int) Math.floor(v);
            int c;
            if(uv == dv){
                dv--;
            }
            if (v > uv - 0.5) {
                c = dv * 2 + 1;
            }else {
                c = 2 * dv;
            }
            System.out.println(c);
        }
    }
}
