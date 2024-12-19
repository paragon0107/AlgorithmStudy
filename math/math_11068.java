import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_11068 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(br.readLine());
            boolean ispalindrome = false;
            for (int j = 2; j <= 64; j++) {

                String str = convertString(j,s);
                boolean flag = true;
                for (int k = 0; k < str.length() / 2; k++) {
                    if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                        ispalindrome = false;
                    }
                }

            }
            System.out.println(ispalindrome?1:0);


        }

    }

    private static String convertString(int j, int s) {
        StringBuilder num= new StringBuilder();
        while (s > 0){
            num.append(s % j);
            if(s >= j){
                s %= j;
            }else {
                 s = 0;
            }
        }
        return num.toString();
    }
}
