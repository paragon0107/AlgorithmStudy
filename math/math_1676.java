package math;

import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_1676 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        BigInteger bi = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        String r = bi.toString();

        int c =0;
        for (int i = r.length() - 1; i >= 0; i--) {
            if (r.charAt(i) == '0') {
                c++;
            }
            else{
                break;
            }
        }
        System.out.println(c);
    }
}
