import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());

        char[][] table = new char[M][N];


        int resultCount=64;

        for (int i=0; i<M; i++) {
            String[] input = new String[M];
            input[i] = br.readLine();
            for (int j = 0; j < N; j++) {
                table[i][j] = (input[i].charAt(j));
            }
        }

        for (int a=0; a<M-8; a++) {
            for (int b = 0; b < N - 8; b++) {
                int countA=0;
                int countB=0;

                for (int i = a; i < a + 8; i++) {
                    for (int j = b; j < b + 8; j++) {


                        if ((i + j) % 2 == 0) {    //짝수번째 박스
                            if (table[i][j] == 'W') //1번 케이스
                                countA++;
                            if (table[i][j] == 'B') //2번 케이스
                                countB++;
                        } else {             //홀수 박스
                            if (table[i][j] == 'B') //1번 케이스
                                countA++;
                            if (table[i][j] == 'W') //2번 케이스
                                countB++;
                        }
                    }
                }
                if (Math.min(countA, countB) < resultCount)
                    resultCount = Math.min(countA, countB);
            }
        }
        bw.write(String.valueOf(resultCount));
        bw.flush();
        bw.close();
    }
}
