package samsungdx.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 보급로 {

	static int[][] map;
	static boolean [][] visited;
	static int [][] minimum;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testAmount = Integer.parseInt(br.readLine());

		for (int testCase=1; testCase<=testAmount; testCase++) {
			result = Integer.MAX_VALUE;
			int mapSize = Integer.parseInt(br.readLine());
			map = new int[mapSize][mapSize];
			minimum = new int[mapSize][mapSize];
			fillMinimum();
			visited = new boolean[mapSize][mapSize];

			for (int i=0; i<mapSize; i++) {
				String temp = br.readLine();

				for (int j=0; j<mapSize; j++) {
					map[i][j] = temp.charAt(j);
				}
			}


		}
	}

	private static void fillMinimum() {
		minimum.length
	}
}
