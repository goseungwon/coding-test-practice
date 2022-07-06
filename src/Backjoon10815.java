import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] input, output;
        int n,m=0;

        n= Integer.parseInt(st.nextToken());
        input=new int[n];


        for (int i=0; i<n; i++){
            if (st.hasMoreTokens())
                input[i]= Integer.parseInt(st.nextToken());
            System.out.println(input[i]);
        }

        if (st.hasMoreTokens()) {
            m = Integer.parseInt(st.nextToken());
        }
        output=new int[m];

        for (int j=0; j<m; j++){
            if (st.hasMoreTokens())
                output[j]= Integer.parseInt(st.nextToken());
            System.out.println(output[j]);
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (output[i]==input[j]){
                    sb.append(1+" ");
                    continue;
                }
            }sb.append(0+" ");
        }
        System.out.println(sb);

    }
}
