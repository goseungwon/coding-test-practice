package barkingDog.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon2011 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static String input;
	static int[] result;
	static int answer;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		input = br.readLine();
		result = new int[input.length() + 1];
	}

	private static void solve() {
		if (input.startsWith("0")) return;

		result[0] = 1;
		result[1] = 1;

		for (int i=2; i<=input.length(); i++) {
			int temp2 = Integer.parseInt(input.substring(i-1, i));
			int temp3 = Integer.parseInt(input.substring(i-2, i));
			if (temp2 != 0) result[i] = result[i-1];
			if (temp3 <= 26 && temp3 >= 10) result[i] += result[i-2];

			result[i] %= 1_000_000;
		}
	}

	private static void print() {
		System.out.println(result[input.length()]);
	}
}
