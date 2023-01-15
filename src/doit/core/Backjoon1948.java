package doit.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int node = Integer.parseInt(br.readLine());
        int tc = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<distance>> list = new ArrayList<>();
        ArrayList<ArrayList<distance>> reverseList = new ArrayList<>();
        int[] degree = new int[node + 1];
        int[] result = new int[node + 1];
        for (int i=0; i<=node; i++){
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }


        for (int i=1; i<=tc; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            list.get(from).add(new distance(to, distance));
            reverseList.get(to).add(new distance(from, distance));
            degree[to]++;
        }

        st = new StringTokenizer(br.readLine());
        int sp = Integer.parseInt(st.nextToken());
        int ep = Integer.parseInt(st.nextToken());

        //시간 구하기
        Queue<Integer> queue = new LinkedList<>();
       queue.offer(sp);

        while(!queue.isEmpty()){
            int now = queue.poll();
            for (distance next : list.get(now)){
                degree[next.target]--;
                result[next.target] = Math.max(result[next.target], result[now] + next.value);
                if (degree[next.target] == 0){
                    queue.offer(next.target);
                }
            }
        }

        for (int i=1; i<=node; i++){
            if (degree[i]==0){
                queue.offer(i);
            }
        }


        //도시 개수 구하기
        int count = 0;
        boolean[] visited = new boolean[node+1];
        queue = new LinkedList<>();
        queue.offer(ep);
        visited[ep] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for (distance next : reverseList.get(now)){
                if (result[next.target] + next.value == result[now]){
                    count++;
                    if (visited[next.target] == false){
                        visited[next.target] = true;
                        queue.offer(next.target);
                    }
                }
            }
        }

        System.out.println(result[ep]);
        System.out.println(count);
    }



    private static class distance {
        int target;
        int value;

        public distance(int target, int value) {
            this.target = target;
            this.value = value;
        }
    }
}
