package bj;

import java.util.Scanner;

public class Backjoon12904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();
		StringBuffer input = new StringBuffer(sc.nextLine());
		boolean flag = false;

		while(true) {
			if (input.length()==0) break;
			if (input.toString().equals(answer)) {
				flag = true;
				break;
			}

			if (input.charAt(input.length()-1) == 'A') input.deleteCharAt(input.length()-1);
			else {
				input.deleteCharAt(input.length()-1);
				input.reverse();
			}
		}

		System.out.println(flag ? 1 : 0);
	}
}
