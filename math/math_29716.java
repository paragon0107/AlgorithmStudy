import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_29716 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            int total = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c >= 'A' && c <= 'Z') {
                    total += 4;
                }
                if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                    total += 2;
                }
                if(c == ' '){
                    total +=1;
                }
            }
            if(total <= n){
                result++;
            }
        }
        System.out.println(result);
    }
}
