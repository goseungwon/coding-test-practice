package samsungdx.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon14499 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int[][] map;
	private static int[][] dice = new int[4][3];
	private static int[] moveCommand;
	private static int y;
	private static int x;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		int commandAmount = Integer.parseInt(st.nextToken());

		map = new int[height][width];
		moveCommand = new int[commandAmount];

		for (int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<commandAmount; i++) {
			moveCommand[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void solve() {
		for (int i=0; i< moveCommand.length; i++) {
			int command = moveCommand[i];

			switch (command) {
				case 1 -> {
					if (!isAvailable(y, x + 1)) {
						continue;
					}
					x++;
					move(command);
					checkMap();
				}
				case 2 -> {
					if (!isAvailable(y, x - 1)) {
						continue;
					}
					x--;
					move(command);
					checkMap();
				}
				case 3 -> {
					if (!isAvailable(y - 1, x)) {
						continue;
					}
					y--;
					move(command);
					checkMap();
				}
				case 4 -> {
					if (!isAvailable(y + 1, x)) {
						continue;
					}
					y++;
					move(command);
					checkMap();
				}
			}
		}
	}

	private static boolean isAvailable(int y, int x) {
		return y>=0 && x>=0 && y < map.length && x < map[0].length;
	}

	private static void move(int direction) {
		switch (direction) {
			case 1 -> {
				int temp = dice[1][0];
				dice[1][0] = dice[1][1];
				dice[1][1] = dice[1][2];
				dice[1][2] = dice[3][1];
				dice[3][1] = temp;
			}
			case 2 -> {
				int temp = dice[1][0];
				dice[1][0] = dice[3][1];
				dice[3][1] = dice[1][2];
				dice[1][2] = dice[1][1];
				dice[1][1] = temp;
			}
			case 3 -> {
				int temp = dice[0][1];
				dice[0][1] = dice[1][1];
				dice[1][1] = dice[2][1];
				dice[2][1] = dice[3][1];
				dice[3][1] = temp;
			}
			case 4 -> {
				int temp = dice[0][1];
				dice[0][1] = dice[3][1];
				dice[3][1] = dice[2][1];
				dice[2][1] = dice[1][1];
				dice[1][1] = temp;
			}
		}
	}

	private static void checkMap() {
		if (map[y][x]==0) {
			map[y][x] = dice[3][1];
		} else {
			dice[3][1] = map[y][x];
			map[y][x] = 0;
		}

		System.out.println(dice[1][1]);
	}
}
