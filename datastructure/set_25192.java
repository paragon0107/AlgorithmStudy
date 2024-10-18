package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class set_25192 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Set<String> set = null;
        int c = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                set = new HashSet<>();
            } else if (set != null && !set.contains(s)) {
                c++;
                set.add(s);
            }
        }
        System.out.println(c);
    }
}
