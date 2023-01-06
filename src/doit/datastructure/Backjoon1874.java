package doit.datastructure;

import java.io.*;
import java.util.Stack;

public class Backjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[number];

        Stack<Integer> stack = new Stack<>();

        int value = 1;
        boolean isGood = true;

        for (int i=0; i<number; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (isGood) {
                while (value <= arr[i]) {
                    stack.push(value++);
                    sb.append("+\n");
                }
                if (stack.empty()) {
                    isGood = false;
                    break;
                }
                while (stack.peek() >= arr[i]) {
                    stack.pop();
                    sb.append("-\n");
                    if (stack.empty()) break;
                }
            }
        }
        if (isGood) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
