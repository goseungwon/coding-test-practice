package barkingDog.backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon6603 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int[] lotto = new int[6];
	private static int[] input;
	private static int k;

	public static void main(String[] args) throws IOException {
	  init();
	  print();
	}

	private static void init() throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());

			if (k == 0) {
				break;
			}

			input = new int[k];

			for (int i=0; i<k; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			solve(0, 0);
			bw.write("\n");
		}
	}

	private static void solve(int length, int index) throws IOException {
		if (length == lotto.length) {
			for (int lot : lotto) {
				bw.write(lot + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i=index; i<k; i++) {
			lotto[length] = input[i];
			solve(length+1, i+1);
		}
	}

	private static void print() throws IOException {
		bw.close();
	}
}
