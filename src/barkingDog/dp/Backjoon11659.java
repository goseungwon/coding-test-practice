package barkingDog.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon11659 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int M;
	static int[] input;
	static long[] sum;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N+1];
		sum = new long[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void solve() throws IOException {
		for (int i=1; i<=N; i++) {
			sum[i] = sum[i-1] + input[i];
		}

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			bw.write(sum[end] - sum[start-1] + "\n");
		}
	}

	private static void print() throws IOException {
		bw.close();
	}
}
