package samsungdx.week1.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파핑파핑_지뢰찾기 {
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
	static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
	static int number;
	static Queue<int[]> queue = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testAmount = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= testAmount; testCase++) {
			number = Integer.parseInt(br.readLine());
			map = new char[number][number];
			visited = new boolean[number][number];

			for (int i = 0; i < number; i++) {
				String tmp = br.readLine();

				for (int j = 0; j < number; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == '*')
						visited[i][j] = true;
				}
			}

			for (int i = 0; i < number; i++) {
				for (int j = 0; j < number; j++) {
					int cnt = 0;

					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx < 0 || ny < 0 || nx >= number || ny >= number)
							continue;
						if (map[nx][ny] == '*')
							cnt += 1;
					}

					if (map[i][j] == '.')
						map[i][j] = (char)(cnt + '0');
				}
			}

			int total = 0;

			for (int i = 0; i < number; i++) {
				for (int j = 0; j < number; j++) {

					if (map[i][j] == '0' && !visited[i][j]) {
						bfs(i, j);
						total += 1;
					}
				}
			}

			for (int i = 0; i < number; i++) {
				for (int j = 0; j < number; j++) {
					if (!visited[i][j]) {
						total += 1;
					}
				}
			}
			sb.append("#" + testCase + " " + total + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int i, int j) {
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			explore();
		}
	}

	private static void explore() {
		int[] cur = queue.poll();
		int x = cur[0];
		int y = cur[1];
		for (int k = 0; k < 8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx < 0 || ny < 0 || nx >= number || ny >= number)
				continue;
			if (!visited[nx][ny] && map[nx][ny] == '0') {
				visited[nx][ny] = true;
				queue.add(new int[] {nx, ny});
			} else if (!visited[nx][ny] && map[nx][ny] != '0') {
				visited[nx][ny] = true;
			}
		}
	}
}
