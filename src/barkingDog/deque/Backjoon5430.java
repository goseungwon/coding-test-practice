package barkingDog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Backjoon5430 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
	  init();
	  // solve();
	  print();
	}

	private static void init() throws IOException {
		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			solve();
		}
	}

	private static void solve() throws IOException {
		boolean isReverse = false;
		String[] commands = br.readLine().split("");
		int length = Integer.parseInt(br.readLine());

		String input = br.readLine();
		String[] inputs = input.substring(1, input.length() - 1).split(",");

		Deque<String> deque = new LinkedList<>();

		for (String s : inputs) {
			if (s.isEmpty()) {
				continue;
			}
			deque.add(s);
		}


		try {
			for (String command : commands) {
				if (command.equals("R")) {
					isReverse = !isReverse;
					continue;
				}

				if (command.equals("D")) {
					if (!isReverse) {
						//정순
						deque.removeFirst();
					} else {
						//역순
						deque.removeLast();
					}
				}
			}

			List<String> result;
			if (!isReverse) {
				//정순
				result = new ArrayList<>(deque);
			} else {
				//역순
				result = new ArrayList<>();
				while (!deque.isEmpty()) {
					result.add(deque.removeLast());
				}
			}

			sb.append("[");
			for (int i=0; i<result.size(); i++) {
				sb.append(result.get(i));
				if (result.size() - 1 != i) {
					sb.append(",");
				}
			}
			sb.append("]\n");

		} catch (NoSuchElementException e) {
			sb.append("error\n");
		}

	}

	private static void print() throws IOException {
		System.out.println(sb);
	}
}
