package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bf_30105 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] teeth;
    static Set<Integer> vSet;
    static Set<Integer> kSet;
    static List<Integer> list;
    static int cn;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        teeth = new int[n];
        vSet = new HashSet<>();
        kSet = new HashSet<>();
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            teeth[i] = Integer.parseInt(st.nextToken());
            vSet.add(teeth[i]);
        }

        for(int i =1;i<=n/2;i++){
            kSet.add(teeth[i] - teeth[0]);
        }

        for(int k:kSet){
            boolean f = true;
            for(int i =0;i<n;i++){
                if(vSet.contains(teeth[i] - k)) continue;
                if(vSet.contains(teeth[i] + k)) continue;
                f = false;
                break;
            }
            if(f){
                list.add(k);
            }
        }
        Collections.sort(list);
        for(int k:list){
            sb.append(k).append(" ");
        }
        System.out.println(list.size());
        System.out.println(sb);
    }
}
