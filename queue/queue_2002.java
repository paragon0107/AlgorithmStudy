package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class queue_2002 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        String[] q1 = new String[n];
        String[] q2 = new String[n];
        List<String> p = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            q1[i] = s;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            q2[i] = s;
        }
        int i = 0, j = 0, c = 0;
        while (j < n) {
            if (q1[i].equals(q2[j])) {
                i++;
                j++;
            } else if (p.contains(q1[i])) {
                i++;
            } else {
                c++;
                p.add(q2[j]);
                j++;
            }
        }
        System.out.println(c);
    }
}
