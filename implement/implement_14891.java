import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_14891 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[][] gear = new int[4][8];

        for(int i=0; i<4 ;i++) {
            String s = br.readLine();
            for(int j=0; j<8; j++) {
                gear[i][j] = s.charAt(j) - '0';
            }
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        while (n-->0){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(p == 1){
                int w1 = gear[k][0];
                int w8 = gear[k][7];
                int temp;
                for (int i =1;i<7;i++){
                    temp = gear[k][i];
                    gear[k][i] =temp;
                }
            }





        }
    }
}
