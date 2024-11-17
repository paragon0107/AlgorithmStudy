package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class implement_13335 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q1.add(Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> q2 = new LinkedList<>();
        for(int i =0;i<w;i++){
            q2.add(0);
        }

        int weight = 0;
        int time = 0;
        while (!q2.isEmpty()) {
            time++;
            weight -= q2.poll();
            if(q1.isEmpty()){
                continue;
            }
            if (weight + q1.peek() <= l) {
                int v = q1.poll();
                weight += v;
                q2.add(v);
            }else {
                q2.add(0);
            }
        }
        System.out.println(time);
    }
}
