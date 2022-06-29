import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] table = new boolean[M][N];


        int resultCount = 64;
        int count;


        for (int i = 0; i < M; i++) {           //입력값 비교해서 배열에 T/F저장
            String[] input = new String[M];
            input[i] = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input[i].charAt(j)=='W')
                    table[i][j] = true;
                else
                    table[i][j] = false;
            }
        }

        for (int a = 0; a <= M - 8; a++) {                      //8*8 시작점 지정
            for (int b = 0; b <= N - 8; b++) {
                boolean firstcase = table[a][b];
                int x=(a+b)%2;
                count=0;

                for (int i = a; i < a + 8; i++) {
                    for (int j = b; j < b + 8; j++) {

                        if ((i + j) % 2 == x) {
                            if (table[i][j]!=firstcase)
                                count ++;
                        } else {
                            if (table[i][j]==firstcase)
                                count ++;
                        }
                    }
                }
                resultCount = Math.min(resultCount, count);
            }
        }
        bw.write(String.valueOf(resultCount));
        bw.flush();
        bw.close();
    }
}