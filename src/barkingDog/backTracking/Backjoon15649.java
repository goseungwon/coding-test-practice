package barkingDog.backTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Backjoon15649 {
	private static Scanner sc = new Scanner(System.in);
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] numbers;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[N+1];
		used = new boolean[N+1];
	}

	private static void solve() throws IOException {
		backTracking(0);
	}

	private static void backTracking(int length) throws IOException {
		if (length == M) {
			for (int i=1; i<=M; i++) {
				bw.write(numbers[i] + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i=1; i<=N; i++) {
			if (!used[i]) {
				numbers[length+1] = i;
				used[i] = true;
				backTracking(length+1);
				used[i] = false;
			}
		}
	}

	private static void print() throws IOException {
		bw.close();
	}
}
