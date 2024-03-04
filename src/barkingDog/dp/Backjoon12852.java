package barkingDog.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon12852 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int[] map;
	static int[] results;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N+1];
		results = new int[N+1];
	}

	private static void solve() {
		map[1] = 0;
		results[1] = 0;

		for (int i=2; i<N+1; i++) {
			int temp = map[i-1];
			int index = i-1;

			if (i%2==0 && temp > map[i/2]) {
				temp = map[i/2];
				index = i/2;
			}

			if (i%3==0 && temp > map[i/3]) {
				temp = map[i/3];
				index = i/3;
			}

			map[i] = temp + 1;
			results[i] = index;
		}
	}

	private static void print() {
		System.out.println(map[N]);

		int index = N;
		while (true) {
			System.out.print(index + " ");

			if (index == 1) break;
			index = results[index];
		}
	}
}
