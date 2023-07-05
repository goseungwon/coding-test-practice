package bj;

import java.util.Scanner;

public class Backjoon1195 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input1 = sc.nextLine();
		String input2 = sc.nextLine();

		int answer = input2.length() + input1.length();

		for (int i = -input2.length(); i <= input1.length(); i++) {
			boolean flag = true;
			for (int j = 0; j < input1.length(); j++) {
				if (j - i >= 0 && j - i < input2.length()) {
					if (input2.charAt(j - i) - '0' + input1.charAt(j) - '0' > 3)
						flag = false;
				}
			}
			if (flag) {
				answer = Math.min(answer, Math.max(i + input2.length(), input1.length()) - Math.min(i, 0));
			}
		}
		System.out.println(answer);
	}
}
