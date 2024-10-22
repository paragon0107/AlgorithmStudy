package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tp_21967 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int min = arr[0];
        int max = arr[0];
        for (int end = 1; end < n; end++) {
            if (arr[end] < min) {
                min = arr[end];
            }
            if (arr[end] > max) {
                max = arr[end];
            }

            int diff = start - end + 1;
            if (result < diff) {
                result = diff;
            }
        }

    }
}