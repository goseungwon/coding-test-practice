package barkingDog.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon2583 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[][] map;
	static boolean[][] isVisited;
	static List<Integer> results = new LinkedList<>();

	static final int[] moveX= {0,0,1,-1};
	static final int[] moveY= {1,-1,0,0};

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		int length = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int rectangle = Integer.parseInt(st.nextToken());

		map = new boolean[length][width];
		isVisited = new boolean[length][width];

		for (int i=0; i<rectangle; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j=x1; j<x2; j++) {
				for (int k=y1; k<y2; k++) {
					map[k][j] = true;
				}
			}
		}
	}

	private static void solve() {
		Stack<Node> stack = new Stack<>();
		Node node = null;

		for (int i=0; i<map[0].length; i++) {
			for (int j=0; j<map.length; j++) {
				if (map[j][i] || isVisited[j][i]) {
					continue;
				}

				int result = 1;
				stack.push(new Node(j,i));
				isVisited[j][i] = true;

				while(!stack.isEmpty()) {
					node = stack.pop();
					
					for (int k=0; k<4; k++) {
						int movedX = node.x + moveX[k];
						int movedY = node.y + moveY[k];
						
						if (movedY>=0 && movedX>=0 && movedY< map.length && movedX<map[0].length && !isVisited[movedY][movedX] && !map[movedY][movedX]) {
							stack.push(new Node(movedY, movedX));
							isVisited[movedY][movedX] = true;
							result++;
						}
					}

				}
				results.add(result);

			}
		}
	}

	private static void print() {
		System.out.println(results.size());
		Collections.sort(results);
		results.forEach((result) -> System.out.print(result + " ") );
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
