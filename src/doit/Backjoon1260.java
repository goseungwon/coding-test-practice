package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon1260 {
    static ArrayList<Integer>[] list;
    static StringBuilder sb;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        list = new ArrayList[node+1];
        dfsVisited = new boolean[node+1];
        bfsVisited = new boolean[node+1];

        for (int i=1; i<=node; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i=1; i<=edge; i++){
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            list[temp1].add(temp2);
            list[temp2].add(temp1);
        }

        for (int i=1; i<=node; i++) {
            Collections.sort(list[i]);
        }


        DFS(start);
        sb.append("\n");
        BFS(start);

        System.out.println(sb);
    }

    private static void DFS(int start) {
        if (dfsVisited[start]){
            return;
        }
        dfsVisited[start]=true;
        sb.append(start + " ");
        for (int n :list[start]){
            DFS(n);
        }
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        bfsVisited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr + " ");
            for (int n : list[curr]){
                if (!bfsVisited[n]){
                    bfsVisited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
