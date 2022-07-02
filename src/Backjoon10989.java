import java.io.*;

public class Backjoon10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<n; i++){
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int s1 = arr[j];
                    arr[j] = arr[i];
                    arr[i] = s1;
                }
            }bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
