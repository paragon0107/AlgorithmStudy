package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_1206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int[] arr = new int[n];
        int start = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = -1;
            if (s.charAt(i) == 'O') {
                if(start == 0){
                    start = i;
                }
                arr[i] = i * i;
            }
        }

        for (int i = start + 1; i < n; i++) {
            for (int j = start; j < i; j++) {
                if ((s.charAt(i) == 'B' && s.charAt(j) == 'J') || (s.charAt(i) == 'O' && s.charAt(j) == 'B') || (s.charAt(i) == 'J' && s.charAt(j) == 'O')) {
                    int cV = arr[j] + (i - j) * (i - j);
                    if (arr[i] == -1) {
                        arr[i] = cV;
                    } else {
                        arr[i] = Math.min(arr[i], cV);
                    }
                }
            }
        }

        System.out.println(arr[n - 1]);
    }
}
