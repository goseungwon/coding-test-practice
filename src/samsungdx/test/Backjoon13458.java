package samsungdx.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon13458 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static long result;
	private static int[] input;
	private static int mainViewer;
	private static int subViewer;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int classAmount = Integer.parseInt(br.readLine());
		result = classAmount;

		input = new int[classAmount];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<classAmount; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		mainViewer = Integer.parseInt(st.nextToken());
		subViewer = Integer.parseInt(st.nextToken());
	}

	private static void solve() {
		for (int i=0; i<input.length; i++) {
			input[i] -= mainViewer;

			if (input[i] <= 0) continue;

			result += (input[i] / subViewer);

			if (input[i] % subViewer > 0) result++;
		}
	}

	private static void print() {
		System.out.println(result);
	}
}
