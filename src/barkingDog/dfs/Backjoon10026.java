package barkingDog.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Backjoon10026 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static char[][] map;
	static boolean[][] isVisited;
	private static final int[] moveX = {0,0,1,-1};
	private static final int[] moveY = {1,-1,0,0};
	static int result = 0;

	public static void main(String[] args) throws IOException {
		String a = "AAAA";

	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		isVisited = new boolean[N][N];

		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
	}

	private static void solve() {
		dfs('R', 'R');
		dfs('G', 'G');
		dfs('B', 'B');

		System.out.print(result + " ");

		result = 0;
		isVisited = new boolean[map.length][map[0].length];
		dfs('R', 'G');
		dfs('B', 'B');
		System.out.println(result);
	}

	private static void dfs(char color1, char color2) {
		Deque<Node> stack  = new ArrayDeque<>();

		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if ((map[i][j]==color1 || map[i][j]==color2) && !isVisited[i][j]) {
					stack.add(new Node(i,j));
					isVisited[i][j]= true;
					result++;

					while(!stack.isEmpty()) {
						Node node = stack.pop();

						for (int k=0; k<4; k++) {
							int movedX = node.x + moveX[k];
							int movedY = node.y + moveY[k];

							if (movedX>=0 && movedY>=0 && movedX <map[0].length && movedY<map.length) {
								if ((map[movedY][movedX]==color1 || map[movedY][movedX]==color2) && !isVisited[movedY][movedX]) {
									stack.add(new Node(movedY, movedX));
									isVisited[movedY][movedX] = true;
								}
							}
						}
					}
				}
			}
		}
	}


	private static void print() {

	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
