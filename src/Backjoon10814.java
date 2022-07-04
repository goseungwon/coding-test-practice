import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Backjoon10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        String[][] arr = new String[101][100];

//        int n = Integer.parseInt(br.readLine());
        int n = sc.nextInt();

       for (int i=0; i<n; i++){
//               int age = Integer.parseInt(st.nextToken());
//               String name = st.nextToken();
               int age = sc.nextInt();
               String name = sc.next();

               int cursor = 0;
               while (arr[age][cursor] != null) {
                   cursor++;
               }
               arr[age][cursor] = name;
       }
       for (int i=1; i<100;){
           int cursor=0;
           while (arr[i][cursor]!=null){
               sb.append(i + " " + arr[i][cursor] + "\n");
               cursor++;
           }i++;
       }
        System.out.println(sb);
    }
}
