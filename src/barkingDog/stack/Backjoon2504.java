package barkingDog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon2504 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = 0;
	static String[] input;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		input = br.readLine().split("");
	}

	private static void solve() {
		Stack<String> stack = new Stack<>();
		int tempResult = 1;

		for (int i=0; i<input.length; i++) {
			String current = input[i];

			switch (current) {
				case "(" -> {
					tempResult *= 2;
					stack.push("(");
				}
				case "[" -> {
					tempResult *= 3;
					stack.push("[");
				}
				case ")" -> {
					if (stack.isEmpty() || !stack.peek().equals("(")) {
						result = 0;
						return;
					}
					if (input[i - 1].equals("(")) {
						result += tempResult;
					}

					stack.pop();
					tempResult /= 2;
				}
				case "]" -> {
					if (stack.isEmpty() || !stack.peek().equals("[")) {
						result = 0;
						return;
					}
					if (input[i - 1].equals("[")) {
						result += tempResult;
					}

					stack.pop();
					tempResult /= 3;
				}
				default -> {
					return;
				}
			}
		}

		if (!stack.isEmpty()) {
			result = 0;
		}

	}

	private static void print() {
		System.out.println(result);
	}
}
