package barkingDog.array;

import java.util.Scanner;

public class Backjoon11328 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		boolean[] results = new boolean[testCase];

		for (int i=0; i<testCase; i++) {
			String input1 = sc.next();
			String input2 = sc.next();

			results[i] = check(input1, input2);
		}

		for (boolean result : results) {
			if (result) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
	}

	private static boolean check(String input1, String input2) {
		if (input1.length() != input2.length()) {
			return false;
		}

		int[] alphabet = new int[26];

		for(int i=0; i<input1.length(); i++) {
			int temp1 = input1.charAt(i) - 'a';
			int temp2 = input2.charAt(i) - 'a';

			alphabet[temp1]++;
			alphabet[temp2]--;
		}

		for (int j : alphabet) {
			if (j != 0) {
				return false;
			}
		}
		return true;
	}
}
