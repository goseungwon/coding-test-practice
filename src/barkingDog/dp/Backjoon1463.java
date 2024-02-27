package barkingDog.dp;

import java.util.Scanner;

public class Backjoon1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] map = new int[1000001];
		map[1] = 0;

		for (int i=2; i<=N; i++) {
			int temp = map[i-1];

			if (i % 3 == 0) {
				temp = Math.min(map[i/3],temp);
			}
			if (i % 2 == 0) {
				temp = Math.min(map[i/2],temp);
			}

			map[i] = temp + 1;
		}

		System.out.println(map[N]);
	}

}
