package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon17298 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    int length = Integer.parseInt(br.readLine());
    int[] arr = new int[length];
    int[] output = new int[length];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i=0; i<length; i++) {
      int current = Integer.parseInt(st.nextToken());
      arr[i] = current;

      while (!stack.isEmpty() && arr[stack.peek()] < current) {
       output[stack.pop()] = current;
      }

      stack.push(i);

    }

    while (!stack.isEmpty()) {
      output[stack.pop()] = -1;
    }

    Arrays.stream(output)
        .forEach((n) -> sb.append(n).append(" "));

    System.out.println(sb);
  }
}