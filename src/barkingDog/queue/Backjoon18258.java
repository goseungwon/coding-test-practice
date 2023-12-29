package barkingDog.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Backjoon18258 {
	private static final Deque<Integer> queue = new LinkedList<>();
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int i=0; i<testCase; i++) {
			st = new StringTokenizer(br.readLine());

			String command = st.nextToken();

			switch (command) {
				case "push" -> push(Integer.valueOf(st.nextToken()));
				case "pop" -> pop();
				case "size" -> size();
				case "empty" -> empty();
				case "front" -> front();
				case "back" -> back();
				default -> throw new RuntimeException("Error command : " + command);
			}
		}
		System.out.println(sb);
	}

	private static void push(Integer input) {
		queue.add(input);
	}

	private static void pop() {
		if (queue.isEmpty()) {
			sb.append("-1\n");
		} else {
			sb.append(queue.removeFirst()).append("\n");
		}
	}

	private static void size() {
		sb.append(queue.size()).append("\n");
	}

	private static void empty() {
		sb.append(queue.isEmpty() ? "1" : "0").append("\n");
	}

	private static void front() {
		if (queue.isEmpty()) {
			sb.append("-1\n");
		} else {
			sb.append(queue.peekFirst()).append("\n");
		}
	}

	private static void back() {
			if (queue.isEmpty()) {
				sb.append("-1\n");
			} else {
				sb.append(queue.peekLast()).append("\n");
			}
	}
}
