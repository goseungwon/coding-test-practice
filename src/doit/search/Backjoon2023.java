package doit.search;

import java.util.Scanner;

public class Backjoon2023 {
	static int input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		input = sc.nextInt();

		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);
	}

	private static void dfs(int number, int length) {
		if (length == input) {
			if (isPrime(number)) {
				System.out.println(number);
			}
			return;
		}

		for (int i = 1; i < 10; i++) {
			if (i % 2 == 0) {
				continue;
			}

			if (isPrime(number * 10 + i)) {
				dfs(number * 10 + i, length + 1);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}

		if (num <= 3) {
			return true;
		}

		if (num % 2 == 0 || num % 3 == 0) {
			return false;
		}

		int sqrtNum = (int) Math.sqrt(num);
		for (int i = 5; i <= sqrtNum; i += 6) {
			if (num % i == 0 || num % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
}
