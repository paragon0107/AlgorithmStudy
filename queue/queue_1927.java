package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class queue_1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if (x>0) {
                queue.add(x);
            } else {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                }
                else{
                    System.out.println(0);
                }
            }
        }
    }
}
