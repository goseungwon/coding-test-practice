package bj;

import java.util.Scanner;

public class Backjoon9935 {
	static StringBuilder sb = new StringBuilder();
	static String bomb;
	static int length;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		bomb = sc.nextLine();
		length = bomb.length();

		for (int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);
			sb.append(ch);
			check();
		}

		if (sb.length()==0) System.out.println("FRULA");
		System.out.println(sb);
	}

	private static void check() {
		if(sb.length() >= length) {
			boolean flag = true;
			for (int j=0; j<length; j++) {
				char c1 = sb.charAt(sb.length() - length + j);
				char c2 = bomb.charAt(j);

				if (c1 != c2) {
					flag = false;
					break;
				}
			}
			if (flag) sb.delete(sb.length()-length, sb.length());
		}

	}
}
