import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] num;

        boolean[] arr =new boolean[2000000001];

        int n = Integer.parseInt(br.readLine());

        num=new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num[i]=Integer.parseInt(st.nextToken());
            arr[num[i]+1000000000]=true;
        }

        for (int i=0; i<n; i++){
            int count=0;
            for (int j=0; j<num[i]+1000000000; j++){
                if (arr[j])
                    count++;
                }
            sb.append(count+" ");
        }
        System.out.print(sb);
    }
}
