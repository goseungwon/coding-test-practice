package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon7576 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static Queue<Node> queue = new LinkedList<>();
	static int[][] map;
	static int[][] count;
	private static final int[] moveHeight = {1, -1, 0, 0};
	private static final int[] moveWidth = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		map = new int[height][width];
		count = new int[height][width];

		for (int i=0; i<height; i++) {
			String[] input = br.readLine().split(" ");
			for (int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == -1) {
					count[i][j] = -1;
				}
			}
		}
	}

	private static void solve() {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if (map[i][j] != 1) {
					continue;
				}
				queue.add(new Node(i,j));
				count[i][j] = 1;
			}
		}

		while (!queue.isEmpty()) {
			Node current = queue.remove();

			for (int i=0; i<4; i++) {
				int currentHeight = current.height + moveHeight[i];
				int currentWidth = current.width + moveWidth[i];

				if (currentHeight >= 0 && currentWidth >= 0 && currentHeight < map.length && currentWidth < map[0].length) {
					if (map[currentHeight][currentWidth] == 0 && count[currentHeight][currentWidth]==0) {
						queue.add(new Node(currentHeight, currentWidth));
						count[currentHeight][currentWidth] = count[current.height][current.width] + 1;
					}
				}
			}
		}

	}

	private static void print() {
		int result = 0;

		for (int i=0; i<map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (count[i][j] == 0) {
					System.out.println(-1);
					return;
				}

				result = Math.max(result, count[i][j]);
			}
		}

		System.out.println(result-1);
	}

	static class Node {
		private int height;
		private int width;

		public Node(int height, int width) {
			this.height = height;
			this.width = width;
		}
	}
}
