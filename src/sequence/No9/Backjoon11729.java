package sequence.No9;

import java.io.*;

public class Backjoon11729 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        bw.write((int) (Math.pow(2, n)-1)+"\n");

        Hanoi(n,1,2,3);

        bw.flush();
        bw.close();

    }


    public static void Hanoi(int n, int start, int mid, int end) throws IOException {

        if (n==1) {
            bw.write(start + " " + end + "\n");
            return;
        }

        Hanoi(n-1, start, end, mid);

        bw.write(start + " " + end + "\n");

        Hanoi(n-1, mid, start, end);
    }
}
