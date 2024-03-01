package barkingDog.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon1149 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[][] expenses;
	//비용 합계에 관한거
	static int[][] results;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		expenses = new int[N][3];
		results = new int[N][3];

		/**
		 * 0 - R
		 * 1 - G
		 * 2 - B
		 */

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				expenses[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void solve() {
		results[0][0] = expenses[0][0];
		results[0][1] = expenses[0][1];
		results[0][2] = expenses[0][2];

		for (int i=1; i<N; i++) {
			for (int j=0; j<3; j++) {
				if (j==0) results[i][j] = Math.min(results[i-1][1], results[i-1][2]) + expenses[i][j];
				if (j==1) results[i][j] = Math.min(results[i-1][0], results[i-1][2]) + expenses[i][j];
				if (j==2) results[i][j] = Math.min(results[i-1][0], results[i-1][1]) + expenses[i][j];
			}
		}
	}

	private static void print() {
		System.out.println(Math.min(Math.min(results[N-1][0], results[N-1][1]), results[N-1][2]));
	}
}
