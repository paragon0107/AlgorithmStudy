package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_1065 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    int count =1;
    List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        while(nums){
            nums.append(nums%10);
            nums/=10;
        }
        if(nums.size()==2){
            int r1 = nums.pop()-nums.pop();
            int r2 = r1;
        }
        int r2 =0;
        int count =0;
        while (r1==r2){
            count+=1;
            if(nums.size()!=0){
                r2 = r1-nums.pop();
            }

        }
    }

    private static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return gcd(b, r);
    }
}
