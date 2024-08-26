import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class math_2108 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> array = new ArrayList<>();
    static int[] count = new int[8001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4001; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            array.add(t);
            count[4000 + t]++;
        }
        average(array);
        middle(array);
        mode(array);
        range(array);
    }

    public static void average(List<Integer> array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        double average = (double) sum / array.size();
        System.out.println(Math.round(average));
    }

    public static void middle(List<Integer> array) {
        Collections.sort(array);
        System.out.println(array.get(array.size() / 2));
    }

    public static void mode(List<Integer> array) {
        int c = 0;
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] > c) {
                c = count[i];
            }
        }
        for (int i = 0; i < 8001; i++) {
            if (c == count[i]) {
                max.add(i-4000);
            }
        }
        Collections.sort(max);
        if(max.size()>1){
            System.out.println(max.get(1));
        }else{
            System.out.println(max.get(0));
        }
    }

    public static void range(List<Integer> array) {
        System.out.println(array.get(array.size() - 1) - array.get(0));
    }
}
