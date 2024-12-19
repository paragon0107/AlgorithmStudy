package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class implement_6986 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Double> arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Double.parseDouble(br.readLine()));
        }
        Collections.sort(arr);

        double arr1;
        double arr2;

        for (int i = 0; i < k; i++) {
            arr.set(i, arr.get(k));
            arr.set(n - 1 - i, arr.get(n - 1 - k));
        }
        double total = 0;
        for (double num : arr) {
            total += num;
        }
        arr2 = total / arr.size();
        for (int i = 0; i < k; i++) {
            arr.set(i, 0d);
            arr.set(n - 1 - i, 0d);
        }
        total = 0;
        for (double num : arr) {
            total += num;
        }
        arr1 = total / (arr.size() - (2 * k));

        System.out.printf("%.2f\n", arr1);
        System.out.printf("%.2f\n", arr2);
    }
}
