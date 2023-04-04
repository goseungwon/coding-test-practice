package programmers;

import java.util.*;

public class 미로_탈출 {
	class Node {
		int x, y, coast;

		public Node(int x, int y, int coast) {
			this.x = x;
			this.y = y;
			this.coast = coast;
		}
	}
	static int[] move = {0, 0, 1, -1};
	static boolean[][] isVisit;
	static int startX, startY=-1;
	public int solution(String[] maps) {
		isVisit = new boolean[maps.length][maps[0].length()];

		//S찾음
		for (int i=0; i<maps.length; i++) {
			for (int j=0; j<maps[i].length(); j++) {
				if (maps[i].charAt(j) == 'S') {
					startX = i;
					startY = j;
					break;
				}
			}
			if (startY >= 0) break;
		}

		int lever = bfs(startX, startY, 0, 'L', maps);
		if (lever < 0) {
			return lever;
		}
		isVisit = new boolean[maps.length][maps[0].length()];

		return bfs(startX, startY, lever, 'E', maps);
	}

	int bfs (int x, int y, int coast, char c, String[] maps) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(x,y, coast));
		isVisit[x][y] = true;

		while(!queue.isEmpty()) {
			Node node = queue.poll();

			if (maps[node.x].charAt(node.y) ==c) {
				startY = node.y;
				startX = node.x;
				return node.coast;
			}

			for (int i=0; i< move.length; i++) {
				int dx = node.x + move[i];
				int dy = node.y + move[move.length - i - 1];
				if (dx>=0 && dy>=0 && dx<isVisit.length && dy<isVisit[0].length) {
					if (!isVisit[dx][dy] && maps[dx].charAt(dy)!='X') {
						isVisit[dx][dy] = true;
						queue.offer(new Node(dx,dy, node.coast+1));
					}

				}
			}
		}
		return -1;
	}
}
