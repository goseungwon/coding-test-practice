package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon7562 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int width;
	static int length;
	static int height;
	static int result = 0;
	static int emptyCount = 0;
	static int[][][] map;
	static boolean[][][] isVisited;
	static final int[] moveWidth= {0,0,0,0,1,-1};
	static final int[] moveLength= {0,0,1,-1,0,0};
	static final int[] moveHeight= {1,-1,0,0,0,0};

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		width = Integer.parseInt(st.nextToken());
		length = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());

		map = new int[width][length][height];
		isVisited = new boolean[width][length][height];

		for (int z = 0; z<height; z++) {
			for (int y = 0; y<length; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < width; x++) {
					map[x][y][z] = Integer.parseInt(st.nextToken());

					if (map[x][y][z] == -1) emptyCount++;
				}
			}
		}
	}

	private static void solve() {
		Queue<Node> queue = new LinkedList<>();

		for (int z = 0; z<height; z++) {
			for (int y = 0; y<length; y++) {
				for (int x = 0; x < width; x++) {
					if (map[x][y][z] == 1) {
						queue.add(new Node(x,y,z, 0));
						isVisited[x][y][z] = true;
					}
				}
			}
		}

		if (queue.size() == width * length * height - emptyCount) return;
		if (queue.isEmpty()) {
			result = -1;
			return;
		}

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			result = Math.max(result, node.day);

			for (int i=0; i<6; i++) {
				int x = node.width + moveWidth[i];
				int y = node.length + moveLength[i];
				int z = node.height + moveHeight[i];

				if (x>=0 && y>=0 && z>=0 && x<width && y<length && z<height) {
					if (map[x][y][z] == 0 & !isVisited[x][y][z]) {
						map[x][y][z] = 1;
						queue.add(new Node(x,y,z, node.day + 1));
						isVisited[x][y][z] = true;
					}
				}
			}
		}
	}

	private static void print() {
		if (result <= 0) {
			System.out.println(result);
			return;
		}

		for (int z = 0; z<height; z++) {
			for (int y = 0; y<length; y++) {
				for (int x = 0; x < width; x++) {
					if (map[x][y][z] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(result);
	}

	static class Node {
		int width;
		int length;
		int height;
		int day;

		public Node(int width, int length, int height, int day) {
			this.width = width;
			this.length = length;
			this.height = height;
			this.day = day;
		}
	}
}
