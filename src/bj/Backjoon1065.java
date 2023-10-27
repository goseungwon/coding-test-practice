package bj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backjoon1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int MAX = sc.nextInt();
		int count = 0;

		for (int i=1; i<=MAX; i++) {
			if (isHanNumber(i)) {
				count++;
			}
		}

		System.out.println(count);
	}

	private static boolean isHanNumber(int input) {
		List<Integer> numbers = new ArrayList<>();
		while(input > 0) {
			numbers.add(input % 10);
			input /= 10;
		}

		if (numbers.size() <= 2) {
			return true;
		}

		int interval = numbers.get(1) - numbers.get(0);

		for (int i=1; i<numbers.size()-1; i++) {
			if (interval != numbers.get(i+1) - numbers.get(i)) {
				return false;
			}
		}

		return true;
	}
}
