import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Backjoon10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int age;
        String name;

        String[][] arr = new String[201][1000];

        int n = Integer.parseInt(br.readLine());

       for (int i=0; i<n; i++){
           StringTokenizer st =new StringTokenizer(br.readLine(), " ");
           age = Integer.parseInt(st.nextToken());
           name = st.nextToken();

           int cursor = 0;
           while (arr[age][cursor] != null) {
               cursor++;
           }
           arr[age][cursor] = name;
       }

       for (int i=1; i<201; i++){
           int cursor=0;
           while (arr[i][cursor]!=null){
               sb.append(i + " " + arr[i][cursor] + "\n");
               cursor++;
           }
       }
        System.out.println(sb);
    }
}
