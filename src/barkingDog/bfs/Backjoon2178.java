package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon2178 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());

		map = new int[height][width];
		count = new int[height][width];

		for (int i=0; i<height; i++) {
			String[] input = br.readLine().split("");
			for (int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
	}

	private static void solve() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0,0));
		count[0][0] = 1;

		while(!queue.isEmpty()) {
			Node current = queue.remove();

			for (int k = 0; k<4; k++) {
				int currentHeight = current.height + moveHeight[k];
				int currentWidth = current.width + moveWidth[k];

				if (currentHeight>=0 && currentWidth>=0 && currentHeight < map.length && currentWidth < map[0].length) {
					if (map[currentHeight][currentWidth]==1 && count[currentHeight][currentWidth] == 0) {
						queue.add(new Node(currentHeight, currentWidth));
						count[currentHeight][currentWidth] = count[current.height][current.width]+1;
					}
				}
			}
		}
	}

	private static void print() {
		System.out.println(count[count.length-1][count[0].length-1]);
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
