package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1516 {

    public static void main(String[] args) throws IOException {

        int[] degree;
        int[] result;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] time;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        degree = new int[tc + 1];
        result = new int[tc + 1];
        time = new int[tc + 1];


        for (int i=0; i<=tc; i++){
            list.add(new ArrayList<>());
        }

        for (int i=1; i<=tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) break;

                list.get(temp).add(i);

                degree[i]++;
            }
        }

            Queue<Integer> queue = new LinkedList<>();
            for (int i=1; i<=tc; i++){
                if (degree[i]==0){
                    queue.offer(i);
                }
            }

            while(!queue.isEmpty()){
                int now = queue.poll();
                System.out.println("now = " + now);
                for (int next : list.get(now)){
                    System.out.println("next = " + next);
                    degree[next]--;
                    result[next]  = Math.max(result[next], result[now] + time[now]);
                    if (degree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            for (int i=1; i<=tc; i++) {
                System.out.println(result[i] + time[i]);
            }
    }
}
