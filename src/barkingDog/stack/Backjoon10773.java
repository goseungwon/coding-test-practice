package barkingDog.stack;

import java.util.Scanner;
import java.util.Stack;

public class Backjoon10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();

		int testCase = sc.nextInt();

		for (int i=0; i<testCase; i++) {
			int input = sc.nextInt();

			if (input == 0) {
				if (!stack.empty()) {
					stack.pop();
				}
				continue;
			}

			stack.push(input);
		}

		int result = 0;
		while (!stack.empty()) {
			 result += stack.pop();
		}

		System.out.println(result);

	}
}
