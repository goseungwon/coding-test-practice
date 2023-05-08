package bj;

import java.util.Scanner;

public class Backjoon9663 {
	static int N;
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int[] arr = new int[N];

		queen(arr, 0);

		System.out.println(answer);

	}
	private static void queen(int[] arr, int count) {
		if (count==N) {
			answer++;
			return;
		}

		for (int i=0; i<N; i++) {
			arr[count] = i;

			if (check(arr, count)) {
				queen(arr, count+1);
			}
		}

	}

	private static boolean check(int[] arr, int count) {
		for (int i=0; i<count; i++) {
			if (arr[i] == arr[count]) return false;
			if (Math.abs(count-i) == Math.abs(arr[count]-arr[i])) return false;
		}
		return true;
	}
}
