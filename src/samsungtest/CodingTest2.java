package samsungtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodingTest2 {
    static Queue<Character> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static  String max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int index=1; index<=testCase; index++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean isFirstZero = true;
            boolean trigger = false;

            max = st.nextToken();
            char x = st.nextToken().charAt(0);
            char y = st.nextToken().charAt(0);
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
                        if (current != '0') trigger = true;
                        else if (!backTracking(i)) break;
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

        char current = max.charAt(i);

        if (current>y)
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
