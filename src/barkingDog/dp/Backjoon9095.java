package barkingDog.dp;

import java.util.Scanner;

public class Backjoon9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] map = new int[11];
		map[1] = 1;
		map[2] = 2;
		map[3] = 4;

		for (int i=4; i<map.length; i++) {
			map[i] = map[i-1] + map[i-2] + map[i-3];
		}

		for (int i=0; i<N; i++) {
			System.out.println(map[sc.nextInt()]);
		}
	}
}
