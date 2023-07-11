package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon17144 {
	static int[][] map;
	static int row, column;
	static final int[] move = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		row = Integer.parseInt(input[0]);
		column = Integer.parseInt(input[1]);
		int seconds = Integer.parseInt(input[2]);

		map = new int[row][column];
		int top = 0, bottom = 0;

		for (int i = 0; i < row; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < column; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (top == 0 && map[i][j] == -1) {
					top = i;
					bottom = i + 1;
				}
			}
		}
		for (int i = 0; i < seconds; i++) {
			diffusion();
			wind(top, bottom);
		}

		int answer = 2;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				answer += map[i][j];
			}
		}
		System.out.println(answer);
	}

	private static void wind(int top, int bottom) {
		for (int i=top-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}

		for (int i=bottom+1; i<row-1; i++) {
			map[i][0] = map[i+1][0];
		}

		for (int i=0; i<column-1; i++) {
			map[0][i] = map[0][i+1];
			map[row-1][i] = map[row-1][i+1];
		}

		for (int i=0; i<top; i++) {
			map[i][column-1] = map[i+1][column-1];
		}

		for (int i=row-1; i>bottom; i--) {
			map[i][column-1] = map[i-1][column-1];
		}

		for (int i=column-1; i>1; i--) {
			map[top][i] = map[top][i-1];
			map[bottom][i] = map[bottom][i-1];
		}
		map[top][1] = 0;
		map[bottom][1] = 0;
	}

	private static boolean isAvailable(boolean isTop, int row, int moveRow, int moveColumn) {
		if (moveRow < 0 || moveColumn < 0 || moveRow >= map.length || moveColumn >= map[0].length) {
			return false;
		}

		if (isTop) {
			return moveRow <= row;
		} else {
			return moveRow >= row;
		}
	}

	private static void diffusion() {
		int tempMap[][] = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (map[i][j] < 5) {
					continue;
				}
				int temp = map[i][j] / 5;

				for (int k = 0; k < move.length; k++) {
					int moveRow = i + move[k];
					int moveColumn = j + move[move.length - 1 - k];

					if (moveRow < 0 || moveColumn < 0 || moveRow >= map.length || moveColumn >= map[0].length) {
						continue;
					}
					if (map[moveRow][moveColumn] == -1) {
						continue;
					}

					map[i][j] -= temp;
					tempMap[moveRow][moveColumn] += temp;

				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				map[i][j] += tempMap[i][j];
			}
		}

	}
}
