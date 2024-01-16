package barkingDog.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon2667 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static boolean[][] map;
	static List<Integer> results = new ArrayList<>();
	static Deque<Node> stack = new ArrayDeque<>();
	static int result;

	private static final int[] moveX = {0,0,1,-1};
	private static final int[] moveY = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());

		map = new boolean[N][N];

		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<N; j++) {
				if (input.charAt(j)=='1') {
					map[i][j] = true;
				}
			}
		}
	}

	private static void solve() {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if (map[i][j]) {
					result = 1;
					stack.add(new Node(i,j));
					map[i][j]= false;
					dfs();
					results.add(result);
				}
			}
		}
	}

	private static void dfs() {
		while(!stack.isEmpty()) {
			Node node = stack.pop();

			for (int i=0; i<4; i++) {
				int x = node.width + moveX[i];
				int y = node.length + moveY[i];

				if (x>=0 && y>=0 && x<map.length && y<map[0].length && map[y][x]) {
					result++;
					stack.add(new Node(y, x));
					map[y][x]=false;
				}
			}
		}
	}

	private static void print() {
		System.out.println(results.size());
		Collections.sort(results);
		results.forEach(System.out::println);
	}

	static class Node {
		int length;
		int width;

		public Node(int length, int width) {
			this.length = length;
			this.width = width;
		}
	}
}
