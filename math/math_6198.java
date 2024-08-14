package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class math_6198 {

    /*
    * 2
    * 10
    * 3
    * 2
    * 8
    * 7
    * 6
    * 4
    * 12
    * 2
    * 3
    *
    *
    *
    * 2 10 8 12 3
    * 0 2  3 1  0
    *        2
    * */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
        long count=0;
        int n = Integer.parseInt(br.readLine());

        for(int i =0;i<n;i++){
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()&&stack.peek()<= h){
                stack.pop();
            }
            count+=stack.size();
            stack.push(h);
        }
        System.out.println(count);
    }
}
