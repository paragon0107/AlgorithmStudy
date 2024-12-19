package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_5582 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] arr1 = new int[4001];
    static int[] arr2 = new int[4001];
    static int[][] cal = new int[4002][4002];

    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();
        int result = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cal[i][j] = cal[i - 1][j - 1] + 1;
                    result = Math.max(result, cal[i][j]);
                }
            }
        }
        System.out.println(result);
    }
}
