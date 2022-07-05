import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] num, num2;

        int n = Integer.parseInt(br.readLine());

        num=new int[n];
        num2=new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num[i]=Integer.parseInt(st.nextToken());
            num2[i]=num[i];
        }

//-----------------------------------------------------
//        for (int i=0; i<n; i++){
//            int count=0;
//            for (int j=0; j<n; j++) {
//                if (num[i] > num[j]) {
//                    count++;
//                }
//            }
//                sb.append(count+" ");
//        }

        Arrays.sort(num2);

        for (int i=1; i<num2.length; i++){
            if (num2[i]==num2[i-1]){
                num2[i-1]=1000000000;
            }
        }
        Arrays.sort(num2);

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (num[i]==num2[j]){
                sb.append(j+" ");
                break;
                 }
            }
        }





//---------------------------------------------------
//
//        for (int i=0; i<n; i++){
//            int count=0;
//            for (int j=0; j<n; j++){
//                if (num[i]==num2[j]){
//                sb.append(j-count+" ");
//                break;
//             }
//                if (num2[j]==num2[j+1])
//                    count++;
//            }
//        }
        System.out.print(sb);
    }
}
