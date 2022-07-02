import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Backjoon10814 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int n = sc.nextInt();
//        String[][] arr = new String[n][2];
//
//        for (int i=0; i<n; i++){
//            arr[i][0]=sc.next();
//            arr[i][1]=sc.next();
//        }
//
//        for (int i=0; i<n; i++){
//            for (int j=i+1; j<n; j++){
//                if (Integer.parseInt(arr[i][0])>Integer.parseInt(arr[j][0])){
//                    String s1 = arr[j][0];
//                    arr[j][0] = arr[i][0];
//                    arr[i][0] = s1;
//
//                    s1 = arr[j][1];
//                    arr[j][1] = arr[i][1];
//                    arr[i][1] = s1;
//                }
//            }
//            bw.write(arr[i][0]);
//            bw.write(arr[i][1]+"\n");
//        }
//
//        for (int i=0; i<n; i++){
//                bw.write(arr[i][0]);
//                bw.write(arr[i][1]);
//                bw.write("\n");
//        }
//        bw.flush();
//        bw.close();



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        String[][] arr;

        int n = Integer.parseInt(st.nextToken());

        arr = new String[n][2];

        for (int i=0; i<n; i++){
            for (int j=0; j<2; j++){
                    arr[i][j] = st.nextToken();
            }
        }

        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (Integer.parseInt(arr[i][0])<Integer.parseInt(arr[j][0])){
                    String s1 = arr[j][0];
                    arr[j][0] = arr[i][0];
                    arr[i][0] = s1;

                    s1 = arr[j][1];
                    arr[j][1] = arr[i][1];
                    arr[i][1] = s1;
                }
                bw.write(arr[i][0]);
                bw.write(arr[i][1]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
