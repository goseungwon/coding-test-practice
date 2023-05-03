package bj;

import java.util.Arrays;
import java.util.Scanner;

public class Backjoon1300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();

		long left = 1;
		long right = T;

		while(left<right) {
			long mid = (left + right)/2;
			long count = 0;

			for (int i=1; i<=N; i++) {
				count += Math.min((mid/i), N);
			}

			if (T<= count) right = mid;
			else left = mid+1;

		}
		System.out.println(left);

	}
}
