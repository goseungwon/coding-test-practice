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
	static int[] minPoint;
	static int result = 0;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		pointMap = new int[N];
		minPoint = new int[N];

		for (int i=0; i<N; i++) {
			pointMap[i] = Integer.parseInt(br.readLine());
			result += pointMap[i];
		}
	}

	private static void solve() {
		//초기값
		minPoint[0] = 0;

		if (pointMap.length < 3) {
			return;
		}

		minPoint[1] = pointMap[0];
		minPoint[2] = pointMap[1];

		for (int i=3; i<pointMap.length; i++) {
			minPoint[i] = pointMap[i-1] + Math.min(minPoint[i-2], minPoint[i-3]);
		}
	}

	private static void print() {
		if (minPoint.length < 2) {
			System.out.println(result - minPoint[minPoint.length-1]);
		} else {
			System.out.println(result - Math.min(minPoint[minPoint.length-1], minPoint[minPoint.length-2]));
		}
	}
}
