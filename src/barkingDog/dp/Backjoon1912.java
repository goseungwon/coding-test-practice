package barkingDog.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon1912 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int[] inputs;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		inputs = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void solve() {
		int current = 0;
		int max = Integer.MIN_VALUE;

		for (int i=1; i<=N; i++) {
			if (current < 0) current = 0;
			current += inputs[i];

			if (max < current) max = current;
		}

		System.out.println(max);
	}

	private static void print() {

	}
}
