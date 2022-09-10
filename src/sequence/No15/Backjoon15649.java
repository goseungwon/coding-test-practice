package sequence.No15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon15649 {
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxNum = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        arr = new int[length];
        visit = new boolean[maxNum];

        dfs(maxNum, length, 0);

        System.out.println(sb);

    }

    private static void dfs(int maxNum, int length, int depth){

        if (depth == length){
            for (int num : arr){
                sb.append(num + " ");
            }

            sb.append("\n");
            return;
        }

        for (int i=0; i<maxNum; i++){
            if (!visit[i]){
                visit[i]=true;
                arr[depth]=i+1;
                dfs(maxNum, length, depth+1);
                visit[i]=false;
            }
        }

    }
}
