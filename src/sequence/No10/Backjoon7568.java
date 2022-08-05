package sequence.No10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Backjoon7568 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= sc.nextInt();

        int[][] person = new int[n][2];

        for (int i=0; i<n; i++){
            person[i][0]= sc.nextInt();
            person[i][1]= sc.nextInt();
        }

        for (int m=0; m<n; m++){
            bw.write(vs(n,m,person)+" ");
        }
        bw.flush();
        bw.close();

    }

    public static int vs(int n, int m, int[][] person){
        int count=1;
        for (int i=0; i<n; i++){
            if (person[i][0]>person[m][0] && person[i][1]>person[m][1])
                count++;
        }
        return count;
    }
}
