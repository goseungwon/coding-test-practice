package barkingDog.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon15685 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static boolean[][] map = new boolean[101][101];
	static int result = 0;
	static List<Node> nodes = new ArrayList<>();
	static List<List<Integer>> ways = new ArrayList<>();

	static class Node {
		private int y;
		private int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
	}

	private static void solve() throws IOException {
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ways.add(new ArrayList<>());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes.add(new Node(y,x));

			int direction = Integer.parseInt(st.nextToken());
			ways.get(i).add(direction);

			int age = Integer.parseInt(st.nextToken());
			//움직임 구하기
			getWays(age, 0, i);
		}

		//그리기
		for (int i=0; i<N; i++) {
			Node node = nodes.get(i);
			draw(node.y, node.x, i);
		}
	}

	private static void draw(int y, int x, int nodeIndex) {
		map[y][x] = true;
		int currentY = y;
		int currentX = x;
		for(Integer direction : ways.get(nodeIndex)) {
			switch (direction) {
				case 0 : currentX++; break;
				case 1 : currentY--; break;
				case 2 : currentX--; break;
				case 3 : currentY++; break;
			}

			if (!isGood(currentY, currentX)) {
				break;
			}

			map[currentY][currentX] = true;
		}
	}

	private static boolean isGood(int y, int x) {
		return y>=0 && x>=0 && y<=100 && x<=100;
	}

	private static void getWays(int age, int currentAge, int index) {
		if (age <= currentAge) {
			return;
		}
		// 방향 설정
		List<Integer> way = ways.get(index);
		for (int i = way.size()-1; i>=0; i--) {
			way.add((way.get(i)+1)%4);
		}
		getWays(age, currentAge+1, index);
	}

	private static void print() {
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if (map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) result++;
			}
		}
		System.out.println(result);
	}
}
