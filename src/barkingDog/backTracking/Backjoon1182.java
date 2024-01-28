package barkingDog.backTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Backjoon1182 {
	private static Scanner sc = new Scanner(System.in);
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] map;
	static int expectSum = 0;
	static int result = 0;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int N = sc.nextInt();
		expectSum = sc.nextInt();

		map = new int[N];

		for (int i=0; i<N; i++) {
			map[i] = sc.nextInt();
		}
	}

	private static void solve() {
		backTracking(0, 0);
	}

	private static void backTracking(int index, int sum) {
		if (index == map.length) {
			if (expectSum == sum) {
				result++;
			}
			return;
		}

		backTracking(index+1, sum);
		backTracking(index+1, sum+map[index]);
	}

	private static void print() {
		System.out.println(expectSum==0 ? result -1 : result);
	}
}
