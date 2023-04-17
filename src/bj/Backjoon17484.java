package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon17484 {
	static int[][] arr;
	static int answer = 60000;
	static int[] move = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());

		arr = new int[height][width];

		for (int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<width; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i=0; i<width; i++) {
			dp(0,i,0,-1);
		}

		System.out.println(answer);

	}

	public static void dp(int height, int width, int count, int before) {
		count += arr[height][width];

		if (height == arr.length-1) {
			answer = Math.min(count, answer);
			return;
		}

		for (int i=0; i< move.length; i++) {
			if (i==before) {
				continue;
			}
			int movedWidth = width + move[i];
			if (movedWidth >=0 && movedWidth<arr[0].length) {
				dp(height+1, movedWidth, count, i);
			}

		}
	}
}
