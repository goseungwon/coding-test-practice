package barkingDog.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon13460 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static final int[] moveY = {1,-1,0,0};
	private static final int[] moveX = {0,0,1,-1};

	static int height;
	static int width;
	static String[][] map;
	static int result = Integer.MAX_VALUE;
	static int[] exit = new int[2];

	static class Node {
		int ry;
		int rx;
		int by;
		int bx;
		int count;
	}

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());

		map = new String[height][width];

		for (int i=0; i<height; i++) {
			String input = br.readLine();
			for (int j=0; j<width; j++) {
				map[i][j] = String.valueOf(input.charAt(j));
			}
		}
	}

	private static void solve() {
		bfs();
	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(getStart());

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (current.count > 10) continue;
			if ((current.ry == exit[0] && current.rx == exit[1]) || (current.by == exit[0] && current.bx == exit[1])) {
				if (!(current.by == exit[0] && current.bx == exit[1])) {
					result = Math.min(result, current.count);
				}
				continue;
			}

			for (int i=0; i<4; i++) {
				// 탐색
				queue.add(tilt(current, moveY[i], moveX[i]));
			}

		}
	}

	private static Node getStart() {
		Node node = new Node();
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (map[i][j].equals("R")) {
					node.ry = i;
					node.rx = j;
					map[i][j] = ".";
				} else if (map[i][j].equals("B")) {
					node.by = i;
					node.bx = j;
					map[i][j] = ".";
				} else if (map[i][j].equals("O")) {
					exit[0] = i;
					exit[1] = j;
				}
			}
		}
		return node;
	}

	private static Node tilt(Node current, int my, int mx) {
		// 공이 앞에 있을 때
		int currentRY = current.ry;
		int currentRX = current.rx;
		int currentBY = current.by;
		int currentBX = current.bx;

		while(true) {
			if (currentRX+mx<0 || currentRY+my<0 || currentRX+mx>=map[0].length || currentRY+my>=map.length || map[currentRY+my][currentRX+mx].equals("#") || ((currentRX+mx==currentBX && currentRY+my==currentBY) && !map[currentBY][currentBX].equals("O"))) {
				break;
			}

			currentRY+= my;
			currentRX+= mx;

			if (currentRY==exit[0] && currentRX==exit[1]) {
				break;
			}
		}

		while(true) {
			if (currentBX+mx<0 || currentBY+my<0 || currentBX+mx>=map[0].length || currentBY+my>=map.length || map[currentBY+my][currentBX+mx].equals("#") || ((currentRX==mx+currentBX && currentRY==my+currentBY) && !map[currentRY][currentRX].equals("O"))) {
				break;
			}

			currentBY+= my;
			currentBX+= mx;

			if (currentBY==exit[0] && currentBX==exit[1]) {
				break;
			}
		}

		while(true) {
			if (currentRY==exit[0] && currentRX==exit[1]) {
				break;
			}

			if (currentRX+mx<0 || currentRY+my<0 || currentRX+mx>=map[0].length || currentRY+my>=map.length || map[currentRY+my][currentRX+mx].equals("#") || ((currentRX+mx==currentBX && currentRY+my==currentBY) && !map[currentBY][currentBX].equals("O"))) {
				break;
			}

			currentRY+= my;
			currentRX+= mx;

			if (currentRY==exit[0] && currentRX==exit[1]) {
				break;
			}
		}

		Node moved = new Node();
		moved.count = current.count + 1;
		moved.ry = currentRY;
		moved.rx = currentRX;
		moved.by = currentBY;
		moved.bx = currentBX;

		return moved;
	}

	private static void print() {
		System.out.println(result <= 10 ? result : -1);
	}
}
