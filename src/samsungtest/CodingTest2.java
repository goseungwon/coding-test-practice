package samsungtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CodingTest2 {
    static Deque<Character> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static  String max;
    static char x,y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int index=1; index<=testCase; index++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean isFirstZero = true;
            boolean trigger = false;

            max = st.nextToken();
            x = st.nextToken().charAt(0);
            y = st.nextToken().charAt(0);
            int inputLength = max.length();

            for (int i=0; i<inputLength; i++) {
                char current = max.charAt(i);

                if (current>=y || trigger) {
                    queue.add(y);
                    isFirstZero = false;
                    if (current!=y) trigger = true;
                }

                else if (x=='0' && isFirstZero) {
                    trigger = true;
                }

                else if (current>=x) {
                    queue.add(x);
                    isFirstZero = false;
                    if (current!=x) trigger = true;
                }

                else {
                    if (!isFirstZero) {
                        if (!backTracking(i)) break;
                        else trigger = true;
                    } else trigger = true;
                }
            }
            outputBuilder(index);
        }
        System.out.println(sb);
    }

    private static boolean backTracking(int i) {
        if (queue.isEmpty()) return false;
        if (--i<0) return false;

        char current = max.charAt(i);

        if (current>y) {
            queue.add(y);
            return true;
        }
        else if (current == y) {
            queue.pollLast();
            queue.add(x);
            queue.add(y);
            return true;
        }
        else if (current>x) {
            queue.add(y);
            return true;
        }
        else if (current==x) {
            queue.pollLast();
            if (queue.isEmpty()) { queue.add(y); return true;}
            if (backTracking(i)) queue.add(y);
            else return false;
        }
        return false;
    }

    private static void outputBuilder(int index) {
        sb.append("#" + index + " ");

        if (queue.isEmpty()) {
            sb.append("-1");
        } else {
            while (!queue.isEmpty()) {
                sb.append(queue.poll());
            }
        }
        sb.append("\n");
    }
}
