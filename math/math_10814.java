
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class math_10814 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<String>> array = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0;i<=200;i++){
            array.add(new ArrayList<>());
        }

        for (int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            array.get(age).add(name);
        }

        for (int i =1;i<=200;i++){
            if(!array.get(i).isEmpty()){
                for (String ary:array.get(i)){
                    System.out.println(i+" "+ary);
                }
            }
        }
    }
}