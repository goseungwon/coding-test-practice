package sequence.No13.No11;

import java.io.*;
import java.util.Arrays;

public class Backjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        float count = 0;
        int choia = 0;
        int choib = 0;
        int result = 10000;
        boolean bool = false;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            count += arr[i];
        }

        Arrays.sort(arr);

        if (n == 1)
            result = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                choia++;
            }
            if (arr[i] != arr[i - 1] || i == n) {
                if (choib < choia) {
                    choib = choia;
                    result = arr[i];
                    bool = false;
                } else if (choia == choib && !bool) {
                    if (arr[i] < result) {
                        result = arr[i];
                        bool = true;
                    }else {
                        bool = true;
                    }
                }
                choia = 0;
            }
        }



            bw.write(Math.round(count / n) + "\n");
            bw.write(arr[arr.length / 2] + "\n");
            bw.write(result + "\n");
            bw.write(arr[n-1] - arr[0] +"\n");

            bw.flush();
            bw.close();
    }
}
