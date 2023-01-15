package doit.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Backjoon11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();


        //순서대로 값 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=tc; i++){
            int temp = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > temp){
                deque.removeLast();
            }

            deque.addLast(new Node(i, temp));

            if (deque.getFirst().index <= i-range){
                deque.removeFirst();
            }

            sb.append(deque.getFirst().value + " ");
        }

        System.out.println(sb);

    }

    static class Node{
        public int index;
        public int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
