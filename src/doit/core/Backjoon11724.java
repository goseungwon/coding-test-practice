package doit.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon11724 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        list = new ArrayList[length+1];
        visited = new boolean[length+1];

        for (int i=1; i<=length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<=tc; i++) {
            st = new StringTokenizer(br.readLine());

            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            list[temp1].add(temp2);
            list[temp2].add(temp1);
        }
        int count = 0;

        for (int i=1; i<=length; i++) {
            if (!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int i) {
        visited[i]=true;
        for (int index:list[i]){
            if (!visited[index]){
                DFS(index);
            }
        }
    }
}
