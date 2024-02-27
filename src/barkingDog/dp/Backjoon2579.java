package barkingDog.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon2579 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] pointMap;
	static int[][] maxPoint;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		pointMap = new int[N];
		maxPoint = new int[N][3];

		for (int i=0; i<N; i++) {
			pointMap[i] = Integer.parseInt(br.readLine());
		}
	}

	private static void solve() {
		//초기값
		maxPoint[0][1]=pointMap[0];
		maxPoint[0][2]=0;

		if (pointMap.length==1) {
			return;
		}

		maxPoint[1][1]=pointMap[1];
		maxPoint[1][2]=pointMap[1] + pointMap[0];

		for (int i=2; i< pointMap.length; i++) {
			maxPoint[i][1] = Math.max(maxPoint[i-2][1], maxPoint[i-2][2]) + pointMap[i];
			maxPoint[i][2] = maxPoint[i-1][1] + pointMap[i];
		}
	}

	private static void print() {
		System.out.println(Math.max(maxPoint[maxPoint.length-1][1], maxPoint[maxPoint.length-1][2]));
	}
}
