import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean[] team;
    static int[][] ary;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        ary = new int[n][n];
        team = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0, 0);
        System.out.println(min);
    }

    public static void back(int node, int depth) {
        if (depth == n / 2) {
            diff();
            return;
        }
        for (int i = node; i < n; i++) {
            if (!team[i]) {
                team[i] = true;
                back(i + 1, depth + 1);
                team[i] = false;
            }
        }
    }

    public static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(team[i] && team[j]){
                    start += ary[i][j];
                    start += ary[j][i];
                }
                if(!team[i] && !team[j]){
                    link += ary[i][j];
                    link += ary[j][i];
                }
            }
        }

        int result = Math.abs(start - link);

        min = Math.min(result, min);
    }
}
