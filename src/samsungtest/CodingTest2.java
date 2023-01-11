package samsungtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class CodingTest2 {

    static Deque<Character> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static  String max;
    static char x,y;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int index=1; index<=testCase; index++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean isFirstZero = true;
            boolean trigger = false;
            count = 0;

            max = st.nextToken();
            x = st.nextToken().charAt(0);
            y = st.nextToken().charAt(0);
            int inputLength = max.length();

            for (int i=0; i<inputLength; i++) {
                char current = max.charAt(i);
                if (current>=y || trigger) {
                    deque.add(y);
                    isFirstZero = false;
                    if (current!=y) trigger = true;
                }

                else if (x=='0' && isFirstZero) {
                    trigger = true;
                }

                else if (current>=x) {
                    deque.add(x);
                    isFirstZero = false;
                    if (current!=x) trigger = true;
                }

                else {
                    if (!isFirstZero) {
                        if (!backTracking(i)) break;
                        else {
                            fillDeque();
                        }
                    } trigger = true;
                }
            }
            outputBuilder(index);
        }
        System.out.println(sb);
    }

    private static void fillDeque() {
        for (int i=0; i<count; i++) {
            deque.add(y);
        }
    }

    private static boolean backTracking(int i) {
        while(true) {
             if (--i<0 || deque.isEmpty()) return false;

            char current = max.charAt(i);

            if (current == y) {
                deque.pollLast();
                deque.add(x);
                deque.add(y);
                break;
            }
            else if (current == x) {
                deque.pollLast();
                if (deque.isEmpty()) { deque.add(y); return true;}
                count++;
            }

            else {
                deque.add(y);
                break;
            }
        }
        return true;
    }


    private static void outputBuilder(int index) {
        sb.append("#").append(index).append(" ");

        if (deque.isEmpty()) {
            sb.append("-1");
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.poll());
            }
        }
        sb.append("\n");
    }
}
