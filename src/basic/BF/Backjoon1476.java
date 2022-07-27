package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while(true){
            if (E==S && S==M){
                System.out.println(E);
                break;
            }
            if (Math.min( E, Math.min( S,M ))==S){
                S+=28;
            } else if (Math.min( E, Math.min( S,M ))==M) {
                M+=19;
            }else if (Math.min( E, Math.min( S,M ))==E){
                E+=15;
            }
        }

    }
}
