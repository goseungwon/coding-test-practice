package barkingDog.recursive;

import java.util.Scanner;

public class Backjoon1074 {
	static long result = 0;
	static int R;
	static int C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();

		int length = (int)Math.pow(2, N);

		recursive(length, 0,0);

		System.out.println(result);
	}

	public static void recursive(int length, int r, int c) {
		if (length == 0) {
			return;
		}

		int half = length/2;

		if (R-r >= half && C-c >= half) {
			result += half * half * 3;
			recursive(half, r + half, c + half);
		} else if (R-r >= half) {
			result += half * half * 2;
			recursive(half, r + half, c);
		} else if (C-c >= half) {
			result += half * half;
			recursive(half, r, c + half);
		} else {
			recursive(half, r, c);
		}
	}
}
