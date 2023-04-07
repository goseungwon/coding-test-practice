package bj.No12;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon10816 {

    static Map<Integer, Integer> map = new HashMap<>();
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            if (map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<m; i++){
            int a=Integer.parseInt(st.nextToken());
            if (map.containsKey(a))
                bw.write(map.get(a)+" ");
            else bw.write(0+" ");
        }
        bw.flush();
        bw.close();
    }
}
