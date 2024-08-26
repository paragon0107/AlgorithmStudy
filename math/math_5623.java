package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class math_5623 {
    /*
     *  0 + 1 = 3
     *  0 + 2 = 6
     *  0 + 3 = 7
     *  1 + 2  = 5
     *  1 + 3 = 6
     *  2 4
     *
     * */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[][] ary = new int[t][t];
        int[] listA = new int[t];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < t; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (t == 2){
            listA[0] = 1;
            listA[1] = 1;
        }else {
            for (int i = 2; i < t; i++) {
                int a = ary[0][i] - ary[0][1];
                int b = (ary[1][i] + a) / 2;
                listA[i] = b;
            }
            listA[1] = ary[1][2] - listA[2];
            listA[0] = ary[1][0] - listA[1];
        }
        for (int r : listA) {
            System.out.print(r + " ");
        }
    }
}
