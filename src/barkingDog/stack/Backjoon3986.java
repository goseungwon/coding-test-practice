package barkingDog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon3986 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int testCase;
	static int result = 0;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		testCase = Integer.parseInt(br.readLine());

	}

	private static void solve() throws IOException {
		for (int i = 0; i < testCase; i++) {
			Stack<String> stack = new Stack<>();
			String[] inputs = br.readLine().split("");

			if (inputs.length % 2 != 0) {
				continue;
			}

			for (String input : inputs) {
				if (stack.empty()) {
					stack.push(input);
				} else if (stack.peek().equals(input)){
					stack.pop();
				} else {
					stack.push(input);
				}
			}
			if (stack.empty()) {
				result++;
			}
		}
	}

	private static void print() {
		System.out.println(result);
	}
}
