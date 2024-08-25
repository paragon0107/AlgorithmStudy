package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_1343 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int[] nums = new int[51];
        String s = br.readLine();
        int c =0;
        for(int i =0;i<s.length();i++){
            String value = String.valueOf(s.charAt(i));
            if("X".equals(value)){
                nums[c]++;
            }
            if(".".equals(value)){
                c++;
            }
        }

        for (int i =0;i<= c;i++){
            while (nums[i]>=4){
                nums[i] -= 4;
                sb.append("AAAA");
            }
            while (nums[i]>=2){
                nums[i] -= 2;
                sb.append("BB");
            }
            if(nums[i]!=0){
                sb.setLength(0);
                sb.append("-1");
                break;
            }
            if(i!=c){
                sb.append(".");
            }
        }
        System.out.println(sb);
    }
}
