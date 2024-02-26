package barkingDog.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Backjoon5648 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static Scanner sc = new Scanner(System.in);

	static int N;
	static long[] numbers;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		// st = new StringTokenizer(br.readLine());
		// N = Integer.parseInt(st.nextToken());
		N = sc.nextInt();
		numbers = new long[N];
		// int index = 0;
		//
		// while (index < N) {
		// 	if (!st.hasMoreTokens()) {
		// 		st = new StringTokenizer(br.readLine());
		// 	}
		// 	numbers[index++] = Long.parseLong(st.nextToken());
		// }

		for (int i=0; i<N; i++) {
			numbers[i] = sc.nextLong();
		}

	}

	private static void solve() {
		for (int i=0; i<N; i++) {
			numbers[i] = reverse(numbers[i]);
		}

		Arrays.sort(numbers);
	}

	private static long reverse(long number) {
		long output = 0;

		while (number>0) {
			output = output * 10 + number % 10;
			number /= 10;
		}

		return output;
	}

	private static void print() {
		Arrays.stream(numbers)
				.forEach(System.out::println);
	}
}
