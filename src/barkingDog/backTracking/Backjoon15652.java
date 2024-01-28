package barkingDog.backTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Backjoon15652 {
	private static Scanner sc = new Scanner(System.in);
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int[] map;
	static int length;
	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		N = sc.nextInt();
		length = sc.nextInt();
		map = new int[length];
	}

	private static void solve() throws IOException {
		backTracking(0,1);
	}

	private static void backTracking(int length, int n) throws IOException {
		if (length==map.length) {
			for (int i=0; i<map.length; i++) {
				bw.write(map[i] + " ");
			}
			bw.write("\n");
			return;
		}

		if (n>N) {
			return;
		}

		for (int i=n; i<=N; i++) {
			map[length]=i;
			backTracking(length+1, i);
		}

	}

	private static void print() throws IOException {
		bw.close();
	}
}
