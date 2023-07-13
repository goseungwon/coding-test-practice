package bj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Backjoon1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		Integer[] arr = new Integer[input.length()];

		for (int i=0; i<input.length(); i++) {
			arr[i] = (int)input.charAt(i) - '0';
		}

		Arrays.sort(arr, Collections.reverseOrder());

		Arrays.stream(arr)
				.forEach(System.out::print);
	}
}
