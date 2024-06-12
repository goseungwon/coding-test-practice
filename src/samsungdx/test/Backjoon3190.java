package samsungdx.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon3190 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	//0 빈칸 1 사과 -1 뱀
	private static int[][] map;

	private static Queue<Change> changes = new LinkedList<>();

	private static class Change {
		private int second;
		private String heading;

		public Change(int second, String heading) {
			this.second = second;
			this.heading = heading;
		}
	}

	private static class Snake {
		private int y;
		private int x;
		//0 위 1 오른쪽 2 아래 3 왼쪽
		private int direction;

		public Snake(int y, int x, int direction) {
			this.y = y;
			this.x = x;
			this.direction = direction;
		}

		public Snake() {
		}
	}

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	}

	private static void init() throws IOException {
		int size = Integer.parseInt(br.readLine());
		map = new int[size][size];

		int appleAmount = Integer.parseInt(br.readLine());
		for (int i=0; i<appleAmount; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;

			map[y][x] = 1;
		}

		int changeAmount = Integer.parseInt(br.readLine());
		for (int i=0; i<changeAmount; i++) {
			st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String heading = st.nextToken();

			changes.add(new Change(second, heading));
		}
	}

	private static void solve() {
		int seconds = 0;

		Deque<Snake> snakes = new ArrayDeque<>();
		snakes.add(new Snake(0,0,1));
		//0 빈칸 1 사과 -1 뱀
		map[0][0] = -1;

		Snake head = snakes.peek();
		Snake tail = snakes.peek();

		//0 위 1 오른쪽 2 아래 3 왼쪽
		int heading = head.direction;

		while(true) {
			if (!changes.isEmpty()) {
				Change peek = changes.peek();
				//방향 바꾸기
				if (seconds == peek.second) {
					changes.remove();
					if (peek.heading.equals("L")) {
						heading = (heading + 3) % 4;
					} else {
						heading = (heading + 1) % 4;
					}
				}
			}

			seconds++;

			Snake moved = new Snake();
			moved.direction = heading;

			//앞으로 하나 가기
			switch (heading) {
				case 0 -> {
					moved.y = head.y-1;
					moved.x = head.x;
				}
				case 1 -> {
					moved.y = head.y;
					moved.x = head.x+1;
				}
				case 2 -> {
					moved.y = head.y+1;
					moved.x = head.x;
				}
				case 3 -> {
					moved.y = head.y;
					moved.x = head.x-1;
				}
			}

			// 죽음 판별
			if (moved.y<0 || moved.x<0 || moved.y>=map.length || moved.x>=map.length || map[moved.y][moved.x] == -1) {
				break;
			}

			snakes.addFirst(moved);
			head = moved;

			//사과 유무 체크
			if (map[moved.y][moved.x] != 1) {
				map[tail.y][tail.x] = 0;
				snakes.removeLast();
				tail = snakes.peekLast();
			}

			map[moved.y][moved.x] = -1;
		}

		System.out.println(seconds);
	}
}
