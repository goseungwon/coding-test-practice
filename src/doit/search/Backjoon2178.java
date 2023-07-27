package doit.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Backjoon2178 {
	static int[][] map;
	static boolean[][] isVisited;
	static int[] move = {1, -1, 0, 0};
	static int height;
	static int width;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		height = Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);

		map = new int[height][width];
		isVisited = new boolean[height][width];

		for (int i = 0; i < height; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < width; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		bfs(0, 0);
		System.out.println(map[height - 1][width - 1]);
	}

	private static void bfs(int startHeight, int startWidth) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(startHeight, startWidth));
		isVisited[startHeight][startWidth] = true;

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int currentHeight = current.height;
			int currentWidth = current.width;

			for (int i = 0; i < move.length; i++) {
				int dx = currentHeight + move[move.length - 1 - i];
				int dy = currentWidth + move[i];

				if (dx >= 0 && dy >= 0 && dx < height && dy < width && map[dx][dy] != 0 && !isVisited[dx][dy]) {
					isVisited[dx][dy] = true;
					map[dx][dy] = map[currentHeight][currentWidth] + 1;
					queue.add(new Node(dx, dy));
				}
			}
		}

	}

	static class Node {
		int height;
		int width;

		public Node(int height, int width) {
			this.height = height;
			this.width = width;
		}
	}
}
