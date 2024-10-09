package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class implement_21394 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int[] ary = new int[10];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                int m = Integer.parseInt(st.nextToken());
                if (j == 6) {
                    ary[9] += m;
                } else {
                    ary[j] += m;
                }
            }
            LinkedList<Integer> q1 = new LinkedList<>();
            LinkedList<Integer> q2 = new LinkedList<>();
            boolean toggle = true;
            for (int j = 9; j >= 0; j--) {
                while (ary[j]-- > 0) {
                    if (toggle) {
                        q1.add(j);
                        toggle = false;
                    } else {
                        q2.addFirst(j);
                        toggle = true;
                    }
                }
            }
            for (int a : q1) {
                sb.append(a).append(" ");
            }for (int a : q2) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
