package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1926 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[][] map;
	static boolean[][] isVisited;
	static int count = 0;
	static int maxSize = 0;
	private static final int[] moveX = {1, -1, 0, 0};
	private static final int[] moveY = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());

		map = new int[height][width];
		isVisited = new boolean[height][width];

		for (int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void solve() {
		Queue<Node> queue = new LinkedList<>();

		for (int i = 0; i<map.length; i++) {
			for (int j = 0; j<map[0].length; j++) {
				if (isVisited[i][j] || map[i][j] != 1) {
					continue;
				}
				int size = 0;
				count++;
				queue.add(new Node(i,j));
				isVisited[i][j] = true;

				while(!queue.isEmpty()) {
					Node current = queue.remove();
					size++;

					for (int k = 0; k<4; k++) {
						int currentHeight = current.height + moveY[k];
						int currentWidth = current.width + moveX[k];

						if (currentHeight>=0 && currentWidth>=0 && currentHeight < map.length && currentWidth < map[0].length) {
							if (map[currentHeight][currentWidth]==1 && !isVisited[currentHeight][currentWidth]) {
								queue.add(new Node(currentHeight, currentWidth));
								isVisited[currentHeight][currentWidth] = true;
							}
						}
					}
				}
				maxSize = Math.max(maxSize, size);
			}
		}
	}

	private static void print() {
		System.out.println(count);
		System.out.println(maxSize);
	}

}

class Node {
	int height;
	int width;

	public Node(int height, int width) {
		this.height = height;
		this.width = width;
	}
}
