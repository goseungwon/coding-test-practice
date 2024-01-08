package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon4179 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static String[][] map;
	static int[][] fire;
	static int[][] jihoon;
	private static final int[] moveHeight = {1, -1, 0, 0};
	private static final int[] moveWidth = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());

		map = new String[height][width];
		fire = new int[height][width];
		jihoon = new int[height][width];

		for (int i=0; i<height; i++) {
			String[] input = br.readLine().split("");
			for (int j=0; j<width; j++) {
				map[i][j] = input[j];

				if (map[i][j].equals("#")) {
					fire[i][j] = -1;
					jihoon[i][j] = -1;
				}
			}
		}
	}

	private static void solve() {
		//불 bfs
		Queue<Node> queue = new LinkedList<>();
		for (int i=0; i<map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j].equals("F")) {
					queue.add(new Node(i,j));
					fire[i][j] = 1;
				}
			}
		}

		while (!queue.isEmpty()) {
			Node current = queue.remove();

			for (int i=0; i<4; i++) {
				int currentHeight = current.height + moveHeight[i];
				int currentWidth = current.width + moveWidth[i];

				if (currentHeight >= 0 && currentWidth >= 0 && currentHeight < map.length && currentWidth < map[0].length) {
					if (!map[currentHeight][currentWidth].equals("#") && fire[currentHeight][currentWidth]==0) {
						queue.add(new Node(currentHeight, currentWidth));
						fire[currentHeight][currentWidth] = fire[current.height][current.width] + 1;
					}
				}
			}
		}

		//지훈 bfs
		jihoonLoop:
		for (int i=0; i<map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j].equals("J")) {
					queue.add(new Node(i,j));
					jihoon[i][j] = 1;
					break jihoonLoop;
				}
			}
		}

		while (!queue.isEmpty()) {
			Node current = queue.remove();

			if (current.height == 0 || current.width == 0 || current.height == map.length-1 || current.width == map[0].length-1) {
				System.out.println(jihoon[current.height][current.width]);
				return;
			}


			for (int i=0; i<4; i++) {
				int currentHeight = current.height + moveHeight[i];
				int currentWidth = current.width + moveWidth[i];

				if (currentHeight >= 0 && currentWidth >= 0 && currentHeight < map.length && currentWidth < map[0].length) {
					if (map[currentHeight][currentWidth].equals(".") && jihoon[currentHeight][currentWidth]==0) {
						if (fire[currentHeight][currentWidth] == 0 || fire[currentHeight][currentWidth] > jihoon[current.height][current.width] + 1) {
							queue.add(new Node(currentHeight, currentWidth));
							jihoon[currentHeight][currentWidth] = jihoon[current.height][current.width] + 1;
						}
					}
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	private static void print() {
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
