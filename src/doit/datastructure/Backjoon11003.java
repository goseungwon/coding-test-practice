package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Backjoon11003 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    Deque<Node> deque = new ArrayDeque<>();

    int length = Integer.parseInt(st.nextToken());
    int boxSize = Integer.parseInt(st.nextToken());
    int current;

    st = new StringTokenizer(br.readLine());
    for (int i=0; i<length; i++) {
      current = Integer.parseInt(st.nextToken());

      while (!deque.isEmpty() && deque.getLast().value>current) {
        deque.removeLast();
      }

      deque.add(new Node(i+1, current));

      if (deque.getFirst().index <= i-boxSize+1) {
        deque.removeFirst();
      }

      sb.append(deque.getFirst().value + " ");
    }

    System.out.println(sb);
  }
}

class Node {
  int index;
  int value;

  public Node(int index, int value) {
    this.index = index;
    this.value = value;
  }
}
