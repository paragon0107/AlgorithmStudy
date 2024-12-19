import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bs_12015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

        public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] lis = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];

        int lengthOfLis = 1;

        for (int i = 1; i < n; i++) {
            int value = arr[i];

            if (lis[lengthOfLis - 1] < value) {
                lis[lengthOfLis] = value;
                lengthOfLis++;
            } else {
                int start = 0;
                int end = lengthOfLis;
                while (start < end) {
                    int mid = (start + end) / 2;

                    if(lis[mid] < value){
                        start = mid +1;
                    }else {
                        end = mid;
                    }
                }

                lis[start] = value;
            }
        }
        System.out.println(lengthOfLis);
    }
}
