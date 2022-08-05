package sequence.No8;

import java.io.*;

import static java.lang.Math.sqrt;

public class Backjoon4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[123456*2];

        arr[1]=1;

        Loop:
        for (int i=2; i<arr.length; i+=2){
                for (int j=3; j<=sqrt(i+1); j+=2) {
                    if ((i+1) % j == 0)
                        if (j!=(i+1))
                            continue Loop;
                }
                arr[i]=1;
            }

        while  (true) {
            int n = Integer.parseInt(br.readLine());
            if (n==0) break;

            int count = 0;

            for (int i = n; i <= (2*n-1); i +=1) {
                    if ((i+1) % 2 == 0 && i>1) {
                        continue;
                    }
                    if (arr[i] != 1){
                        continue;
                    }
                    count++;
                i++;
            }
            bw.write(String.valueOf(count+"\n"));
        }
        bw.flush();
        bw.close();
    }
}
