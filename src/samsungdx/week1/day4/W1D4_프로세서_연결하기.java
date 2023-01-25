package samsungdx.week1.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class W1D4_프로세서_연결하기 {
	private static int boardSize, core, result, count;
	private static int[][] board;
	private static ArrayList<int[]> coreList;
	private final static int[] move = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int testAmount = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= testAmount; testCase++) {
			boardSize = Integer.parseInt(br.readLine());
			coreList = new ArrayList<>();
			board = new int[boardSize][boardSize];

			for (int i = 0; i < boardSize; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < boardSize; j++) {
					board[i][j] = Byte.parseByte(st.nextToken());
					if (board[i][j] == 1 && i != 0 && i != boardSize - 1 && j != 0 && j != boardSize - 1)
						coreList.add(new int[]{i, j});
				}
			}

			core = 0;
			result = Integer.MAX_VALUE;

			dfs(0, 0, 0);
			sb.append("#" + testCase + " " + result+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int depth, int c, int line) {
		if (depth == coreList.size()) {
			if (core < c) {
				core = c;
				result = line;
			} else if (core == c) {
				if (result > line) result = line;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (isConnect(coreList.get(depth), i)) {
				fill(coreList.get(depth), i, 2);
				dfs(depth + 1, c + 1, line + count);
				fill(coreList.get(depth), i, 0);
			}
		}
		dfs(depth + 1, c, line);
	}

	private static void fill(int[] index, int dir, int value) {
		count = 0;

		int x = index[0] + move[dir];
		int y = index[1] + move[3-dir];
		while (x >= 0 && y >= 0 && x < boardSize && y < boardSize) {
			board[x][y] = value;
			count++;
			x = x + move[dir];
			y = y + move[3-dir];
		}
	}

	private static boolean isConnect(int[] index, int dir) {
		int x = index[0] + move[dir];
		int y = index[1] + move[3-dir];

		while (x >= 0 && y >= 0 && x < boardSize && y < boardSize) {
			if (board[x][y] != 0) return false;
			x = x + move[dir];
			y = y + move[3-dir];
		}
		return true;
	}
}