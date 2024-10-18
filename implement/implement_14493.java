package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_14493 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] ary = new int[n][2];
        int time = 1;
        for (int i = 0; i < n; i++) {
            int t = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            t+=b;
            while (true) {

                if(t <= time &&time<t+a){
                    break;
                }else if(t<=time){
                    t+=a;
                    t+=b;
                }else if(time<t){
                    time++;
                }
            }
            time++;
        }
        System.out.println(time);


    }
}
