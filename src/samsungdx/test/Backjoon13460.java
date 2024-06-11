package samsungdx.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon13460 {
	private static Scanner sc = new Scanner(System.in);
	private static String[][] map;
	private static int[] exit = new int[2];
	private static final int[] moveY = {1,-1,0,0};
	private static final int[] moveX = {0,0,1,-1};
	private static int result = Integer.MAX_VALUE;

	private static class Node {
		private int redY;
		private int redX;
		private int blueY;
		private int blueX;
		private int moveCount;

		public Node(int redY, int redX, int blueY, int blueX, int moveCount) {
			this.redY = redY;
			this.redX = redX;
			this.blueY = blueY;
			this.blueX = blueX;
			this.moveCount = moveCount;
		}
	}
	public static void main(String[] args) {
		input();
		bfs();
		print();
	}

	public static void input() {
		int y = sc.nextInt();
		int x = sc.nextInt();
		sc.nextLine();

		map = new String[y][x];

		for (int i=0; i<y; i++) {
			map[i] = sc.nextLine().split("");
		}
	}

	public static Node getStart() {
		int rY = 0;
		int rX = 0;
		int bY = 0;
		int bX = 0;
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				switch (map[i][j]) {
					case "R" -> {
						rY = i;
						rX = j;
					}
					case "B" -> {
						bY = i;
						bX = j;
					}
					case "O" -> {
						exit[0] = i;
						exit[1] = j;
					}
				}
			}
		}

		return new Node(rY, rX, bY, bX, 0);
	}

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(getStart());

		while(!queue.isEmpty()) {
			Node current = queue.poll();

			if (current.moveCount > 10) break;
			if (current.blueY == exit[0] && current.blueX == exit[1]) continue;
			if (current.redY == exit[0] && current.redX == exit[1]) {
				result = Math.min(result, current.moveCount);
			}

			for (int i=0; i<4; i++) {
				queue.add(move(current, moveY[i], moveX[i]));
			}
		}
	}

	public static Node move(Node current, int moveY, int moveX) {
		int movedRedY = current.redY;
		int movedRedX = current.redX;
		int movedBlueY = current.blueY;
		int movedBlueX = current.blueX;

		while(true) {
			if (movedRedY+moveY<0 || movedRedX+moveX<0 || movedRedY+moveY>=map.length || movedRedX+moveX>=map[0].length || map[movedRedY+moveY][movedRedX+moveX].equals("#") || (movedRedY+moveY==movedBlueY && movedRedX+moveX==movedBlueX) && !map[movedBlueY][movedBlueX].equals("O")) {
				break;
			}

			movedRedY += moveY;
			movedRedX += moveX;

			if (movedRedY==exit[0] && movedRedX==exit[1]) {
				break;
			}
		}

		while(true) {
			if (movedBlueY+moveY<0 || movedBlueX+moveX<0 || movedBlueY+moveY>=map.length || movedBlueX+moveX>=map[0].length || map[movedBlueY+moveY][movedBlueX+moveX].equals("#") || (movedBlueY+moveY==movedRedY && movedBlueX+moveX==movedRedX) && !map[movedRedY][movedRedX].equals("O")) {
				break;
			}

			movedBlueY += moveY;
			movedBlueX += moveX;

			if (movedBlueY==exit[0] && movedBlueX==exit[1]) {
				break;
			}
		}

		while(true) {
			if (movedRedY==exit[0] && movedRedX==exit[1]) {
				break;
			}

			if (movedRedY+moveY<0 || movedRedX+moveX<0 || movedRedY+moveY>=map.length || movedRedX+moveX>=map[0].length || map[movedRedY+moveY][movedRedX+moveX].equals("#") || (movedRedY+moveY==movedBlueY && movedRedX+moveX==movedBlueX) && !map[movedBlueY][movedBlueX].equals("O")) {
				break;
			}

			movedRedY += moveY;
			movedRedX += moveX;

			if (movedRedY==exit[0] && movedRedX==exit[1]) {
				break;
			}
		}

		return new Node(movedRedY, movedRedX, movedBlueY, movedBlueX, current.moveCount+1);
	}

	public static void print() {
		System.out.println(result>10 ? -1 : result);
	}

}
