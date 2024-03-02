package barkingDog.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon11726 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int[] results;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	private static void solve() {
		results = new int[N+1];

		results[0] = 1;
		results[1] = 2;

		if (N < 3) {
			return;
		}

		for (int i=2; i<N; i++) {
			results[i] = (results[i-1] + results[i-2]) % 10007;
		}
	}

	private static void print() {
		System.out.println(results[N-1]);
	}
}
