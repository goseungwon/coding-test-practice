package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon6064 {

    static int M,N,x,y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num= Integer.parseInt(br.readLine());

        FFF:
        for (int i=0; i<num; i++){
         StringTokenizer st = new StringTokenizer(br.readLine());

         M= Integer.parseInt(st.nextToken());
         N= Integer.parseInt(st.nextToken());
         x= Integer.parseInt(st.nextToken());
         y= Integer.parseInt(st.nextToken());
         int max=M*N;

        while(true){
            if (x==y) break;
            if (x<y){
                x+=M;
            }else{
                y+=N;
            }
            System.out.println("x  , y = " + x  +" " + y);
            if (x>max|| y>max) break ;
        }
        if (x>max || y>max){
            sb.append(-1+"\n");
        }else {
            sb.append(x + "\n");
        }

        }
        System.out.println(sb);

    }

}
