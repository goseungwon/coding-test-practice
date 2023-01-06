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

        for (int i=0; i<number; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cursor = 0;
        int value = 1;
        boolean isGood = true;

        while (cursor<number) {
            if (stack.empty() || stack.peek()<arr[cursor]) {
                stack.push(value);
                value++;
                sb.append("+\n");
            } else if (stack.peek() == arr[cursor]) {
                stack.pop();
                cursor++;
                sb.append("-\n");
            } else {
                isGood = false;
                break;
            }
        }

        if (isGood) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }


    }
}

