package barkingDog.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon11652 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static long[] inputs;
	static long result;
	static int count = 1;
	static int resultCount = 0;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
			N = Integer.parseInt(br.readLine());
			inputs = new long[N+1];

			for (int i=0; i<N; i++) {
				inputs[i] = Long.parseLong(br.readLine());
			}

			inputs[N] = Long.MAX_VALUE;
	}

	private static void solve() {
		Arrays.sort(inputs);
		result = inputs[0];

		for(int i=0; i<N; i++) {
			if (inputs[i] == inputs[i+1]) {
				count++;
				if (count>resultCount) {
					result = inputs[i];
					resultCount = count;
				}
			} else {
				count = 1;
			}
		}
	}

	private static void print() {
		System.out.println(result);
	}
}
