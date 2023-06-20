package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon14890 {
		static int size;
		static int length;
		static int answer;
		static int [][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		size = Integer.parseInt(temp[0]);
		length = Integer.parseInt(temp[1]);
		answer = size*2;
		map = new int[size][size];

		for (int i=0; i<size; i++) {
			temp = br.readLine().split(" ");
			for (int j=0; j<size; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}

		for (int i=0; i<size; i++) {
			row(i);
			column(i);
		}

		System.out.println(answer);

	}

	private static void row(int i) {
		int ramp = 1;

		for (int j=1; j<size; j++) {
			int diff = map[i][j-1] - map[i][j];

			if (diff==0) ramp++;
			else if (diff == 1 && ramp >= 0) ramp = -length+1;
			else if (diff == -1 && ramp>=length) ramp=1;
			else {
				answer--;
				return;
			}
		}
		if (ramp<0) answer--;
	}

	private static void column(int i) {
		int ramp = 1;

		for (int j=1; j<size; j++) {
			int diff = map[j-1][i] - map[j][i];

			if (diff==0) ramp++;
			else if (diff == 1 && ramp >= 0) ramp = -length+1;
			else if (diff == -1 && ramp>=length) ramp=1;
			else {
				answer--;
				return;
			}
		}
		if (ramp<0) answer--;
	}
}
