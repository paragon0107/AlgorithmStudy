package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_1969 {
    static int N, M;
    static String[] str;
    static int hd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int[] cnt = new int[4];

            for (int j = 0; j < N; j++) {
                char ch = str[j].charAt(i);

                switch (ch) {
                    case 'A':
                        cnt[0]++;
                        break;
                    case 'C':
                        cnt[1]++;
                        break;
                    case 'G':
                        cnt[2]++;
                        break;
                    case 'T':
                        cnt[3]++;
                        break;
                }
            }

            int idx = 0;
            int max = 0;
            for (int k = 0; k < 4; k++) {
                if (cnt[k] > max) {
                    max = cnt[k];
                    idx = k;
                }
            }

            switch (idx) {
                case 0:
                    sb.append('A');
                    break;
                case 1:
                    sb.append('C');
                    break;
                case 2:
                    sb.append('G');
                    break;
                case 3:
                    sb.append('T');
                    break;
            }

            hd += N - max;
        }

        System.out.println(sb.toString());
        System.out.println(hd);
    }
}
