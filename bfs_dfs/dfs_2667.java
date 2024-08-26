package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class dfs_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] ary;
    static int n;
    static int c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ary = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                ary[i][j] = s.charAt(j) - '0';
            }
        }
        int r = 0;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) {
                    nums.add(c);
                    r++;
                    c = 0;
                }
            }
        }
        Collections.sort(nums);
        System.out.println(r);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }

        if (ary[x][y] == 1) {
            c++;
            ary[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny);
            }
            return true;
        }
        return false;
    }
}
