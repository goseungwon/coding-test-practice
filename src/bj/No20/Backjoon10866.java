package bj.No20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Backjoon10866 {
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
            for (int k=0; k<n; k++) {
                String line = br.readLine();
                switch (line){
                    case "front":
                        if (queue.isEmpty()) sb.append(-1+"\n");
                        else sb.append(queue.peekFirst()+"\n");
                        break;
                    case "size":
                        sb.append(queue.size()+"\n");
                        break;
                    case "empty":
                        if (queue.isEmpty()) sb.append(1+"\n");
                        else sb.append(0+"\n");
                        break;
                    case "pop_front":
                        if (queue.isEmpty()) sb.append(-1+"\n");
                        else sb.append(queue.pollFirst()+"\n");
                        break;
                    case "pop_back":
                        if (queue.isEmpty()) sb.append(-1 + "\n");
                        else sb.append(queue.pollLast()+"\n");
                        break;
                    case "back":
                        if (queue.isEmpty()) sb.append(-1+"\n");
                        else sb.append(queue.peekLast()+"\n");
                        break;
                    default :
                        StringTokenizer st = new StringTokenizer(line);
                        String order = st.nextToken();
                        int orderInput = Integer.parseInt(st.nextToken());

                        if (order.equals("push_front")) queue.offerFirst(orderInput);
                        else queue.offerLast(orderInput);
                        break;
                }
            }
            System.out.println(sb);
        }
}
