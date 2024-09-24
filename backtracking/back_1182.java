import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] ary;
    static int goal;
    static int limit;
    static int count =0;
    static int n;
    static int total =0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        ary = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            limit = i;
            back(0,0);
        }
        System.out.println(count);
    }

    public static void back(int node,int depth) {
        if (depth == limit) {
            if(goal == total){
                count++;
            }
            return;
        }
        for (int i = node; i < n; i++) {
               total += ary[i];
                back(i+1,depth+1);
                total -=ary[i];
        }
    }
}
