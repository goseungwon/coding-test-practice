package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1012 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[][] map;
	static boolean[][] isVisited;
	static int result;

	private static final int[] moveHeight = {1, -1, 0, 0};
	private static final int[] moveWidth = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
	  init();
	  // solve();
	  // print();
	}

	private static void init() throws IOException {
		int testCase = Integer.parseInt(br.readLine());

		for (int i=0; i<testCase; i++) {
			initCase();
		}
	}

	private static void initCase() throws IOException {
		st = new StringTokenizer(br.readLine());

		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int cabbageCount = Integer.parseInt(st.nextToken());

		map = new int[height][width];
		isVisited = new boolean[height][width];

		for (int i=0; i<cabbageCount; i++) {
			st = new StringTokenizer(br.readLine());
			int currentWidth = Integer.parseInt(st.nextToken());
			int currentHeight = Integer.parseInt(st.nextToken());

			map[currentHeight][currentWidth] = 1;
		}

		solve();
		print();
	}

	private static void solve() {
		Queue<Node> queue = new LinkedList<>();
		result = 0;

		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if (isVisited[i][j] || map[i][j]!=1) {
					continue;
				}

				result ++;

				queue.add(new Node(i,j));
				isVisited[i][j] = true;

				while(!queue.isEmpty()) {
					Node node = queue.poll();

					for (int k=0; k<4; k++) {
						int currentHeight = node.height + moveHeight[k];
						int currentWidth = node.width + moveWidth[k];

						if (currentHeight >=0 && currentWidth>=0 && currentHeight<map.length && currentWidth<map[0].length
								&& map[currentHeight][currentWidth]==1 && !isVisited[currentHeight][currentWidth]) {
							queue.add(new Node(currentHeight, currentWidth));
							isVisited[currentHeight][currentWidth] = true;
						}
					}

				}
			}
		}
	}

	private static void print() {
		System.out.println(result);
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
