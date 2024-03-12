package barkingDog.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon10844 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int[][] numbers;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		numbers = new int[N+1][10];
	}

	private static void solve() {
		for (int i=1; i<10; i++) {
			numbers[1][i] = 1;
		}

		for (int i=1; i<N; i++) {
			for (int j=0; j<10; j++) {
				int number = numbers[i][j];

				if (number == 0) continue;

				if (j - 1 >= 0) numbers[i+1][j-1] = (numbers[i+1][j-1] + number) % 1_000_000_000;
				if (j + 1 < 10) numbers[i+1][j+1] = (numbers[i+1][j+1] + number) % 1_000_000_000;
			}
		}
	}


	private static void print() {
		int result = 0;
		for (int i=0; i<10; i++) {
			result = (result + numbers[N][i]) % 1_000_000_000;
		}

		System.out.println(result);
	}
}
