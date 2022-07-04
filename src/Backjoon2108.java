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
        int resultb = 10000;


        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            count += arr[i];
        }

        Arrays.sort(arr);

        if (n == 1) {
            result = arr[0];
        } else {
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i - 1]) {
                    choia++;
                } else {
                    if (choib < choia) {
                        choib = choia;
                        result = arr[i];
                    } else if (choia == choib) {
                        choib = choia;
                        if (result > arr[i]) {
                            if (arr[i] < resultb) {
                                result = resultb;
                                resultb = arr[i];
                            } else {
                                result = arr[i];
                            }
                        }
                        choia = 0;
                    }
                }
            }


            bw.write(Math.round(count / n) + "\n");
            bw.write(arr[arr.length / 2] + "\n");
            bw.write(result + "\n");
            bw.write(arr[n - 1] - arr[0]);

            bw.flush();
            bw.close();
        }
    }
}
