package barkingDog.backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon9663 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int[] map;
	static int result = 0;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N];
	}

	private static void solve() {
		backTracking(0);
	}

	private static void backTracking(int height) {
		if (height == N) {
			result++;
			return;
		}

		for (int i=0; i<N; i++) {
			if (check(height, i)) {
				map[height] = i;
				backTracking(height+1);
			}
		}
	}

	private static boolean check(int height, int width) {
		for (int i=0; i<height; i++) {
			int i1 = map[i];
			if (i1 ==width || i1+i == height+width || i1-i == width-height) {
				return false;
			}
		}
		return true;
	}

	private static void print() {
		System.out.println(result);
	}
}
