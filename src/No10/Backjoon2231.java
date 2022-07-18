package No10;

import java.io.*;

public class Backjoon2231 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n=Integer.parseInt(br.readLine());
        int length = (int) Math.log10(n)+1;

        Loop:
        for (int i=n-9*length; i<=n; i++){
            if (i==n){
                bw.write(String.valueOf(0));
                break;
            }
            int result=i;
            int count=i;
            while(count>0){
                result += count%10;
                count=count/10;
            }
            if (result==n) {
                bw.write(String.valueOf(i));
                break Loop;
            }
        }

        bw.flush();
        bw.close();

    }
}
