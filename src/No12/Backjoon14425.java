package No12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon14425 {

    static Map<String, Integer> S=new HashMap<>();
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count=0;


        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());


        for (int i=0; i<n; i++){
            S.put(br.readLine(),0);
        }

        for (int i=0; i<m; i++){
            String input=br.readLine();
                if (S.containsKey(input)){
                    count++;
                }
            }
        System.out.println(count);
    }
}
