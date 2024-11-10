package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class implement_21608 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] arr;
    static int n;
    static int[] order;
    static int[][] like;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        like = new int[n * n + 1][4];
        order = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            order[i] = num;
            for (int j = 0; j < 4; j++) {
                like[num][j] = Integer.parseInt(st.nextToken());
            }
        }//400

        for (int o : order) {
            boolean done = false;
            List<int[]> max1 = new ArrayList<>();
            int maxC = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] != 0) {
                        continue;
                    }
                    int c = checkLike(i, j, like[o][0], like[o][1], like[o][2], like[o][3]);
                    if (maxC < c) {
                        maxC = c;
                        max1 = new ArrayList<>();
                        max1.add(new int[]{i, j});
                    } else if (maxC == c) {
                        max1.add(new int[]{i, j});
                    }
                }
            }

            Queue<int[]> max2 = new LinkedList<>();
            maxC = 0;
            for (int[] xy : max1) {
                int c = checkEmpty(xy[0], xy[1]);
                if (maxC < c) {
                    maxC = c;
                    max2 = new LinkedList<>();
                    max2.add(new int[]{xy[0], xy[1]});
                }
                if (maxC == c) {
                    max2.add(new int[]{xy[0], xy[1]});
                }
            }
            int[] xy = max2.peek();
            arr[xy[0]][xy[1]] = o;

        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += (int) Math.pow(10,checkLikeTotal(i,j)-1);
            }
        }

        System.out.println(result);
    }

    static int checkLike(int x, int y, int a, int b, int c, int d) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == a || arr[nx][ny] == b || arr[nx][ny] == c || arr[nx][ny] == d) {
                    count++;
                }
            }
        }
        return count;
    }

    static int checkEmpty(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                count++;
            }
        }
        return count;
    }

    static int checkLikeTotal(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == like[arr[x][y]][0] || arr[nx][ny] == like[arr[x][y]][1] || arr[nx][ny] == like[arr[x][y]][2] || arr[nx][ny] == like[arr[x][y]][3]) {
                    count++;
                }
            }
        }
        return count;
    }


}
