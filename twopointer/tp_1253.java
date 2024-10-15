import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tp_1253 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = 0;
        int[] ary = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(ary);

        for (int i = 0; i < n; i++) {
            int bottom = 0;
            int top = n - 1;
            while (bottom < top) {
                if (bottom == i) {
                    bottom++;
                    continue;
                }
                if (top == i) {
                    top--;
                    continue;
                }
                if (ary[bottom] + ary[top] == ary[i]) {
                    c++;
                    break;
                } else if (ary[bottom] + ary[top] > ary[i]) {
                    top--;
                } else {
                    bottom++;
                }
            }
        }
        System.out.println(c);
    }
}
