package bj;

import java.util.Scanner;
import java.util.Stack;

public class Backjoon1918 {
	static Stack<String> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();


		for (int i=0; i<input.length(); i++) {
			check(input.charAt(i));
		}

		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb);
	}

	private static void check(char c) {
		if (c >= 'A' && c<= 'Z') {
			sb.append(c);
			return;
		}

		if (c==')') {
			while(!stack.peek().equals("(")) {
				sb.append(stack.pop());
			}
			stack.pop();
			return;
		}

		if (c=='+' || c=='-') {
			while(!stack.isEmpty() && (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*") || stack.peek().equals("/"))) {
				sb.append(stack.pop());
			}
			stack.push(String.valueOf(c));
			return;
		}

		if (c=='*' || c=='/') {
			while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
				sb.append(stack.pop());
			}
			stack.push(String.valueOf(c));
			return;
		}

		stack.push(String.valueOf(c));
	}
}
