import java.io.*;
import java.util.StringTokenizer;

public class Backjoon2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int count=0;

        if ((v-b)%(a-b)>0) count++;
        v=(v-b)/(a-b);
        count+=v;



        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}