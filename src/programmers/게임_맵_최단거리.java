package programmers;

import java.util.*;

class 게임_맵_최단거리 {
	public static void main(String[] args) {
		int[][] arr = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}, {0,0,0,0,1}};
		System.out.println(solution(arr));
	}

	static class Position {
		int x,y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		boolean isValid(int width, int height) {
			if(x<0 || y<0 || x>=width || y>=height) return false;
			return true;
		}
	}

	public static int solution(int[][] maps) {
		int mapHeight = maps.length;
		int mapWidth = maps[0].length;

		Queue<Position> queue = new LinkedList<>();
		boolean[][] visited = new boolean[mapHeight][mapWidth];

		visited[0][0]=true;
		queue.offer(new Position(0,0));

		final int[] moving  = {0, 0, -1, 1};

		while(!queue.isEmpty()) {
			Position current = queue.poll();

			int currentCount = maps[current.y][current.x];

			for(int i=0; i<moving.length; i++) {
				Position moved = new Position(
						current.x + moving[i], current.y + moving[moving.length-i -1]);

				if(!moved.isValid(mapWidth, mapHeight)) continue;
				if(maps[moved.y][moved.x] == 0) continue;
				if(visited[moved.y][moved.x]) continue;

				maps[moved.y][moved.x] = currentCount+1;
				visited[moved.y][moved.x] = true;
				queue.offer(moved);
			}
		}

		if (maps[mapHeight-1][mapWidth-1] <= 1) return -1;
		return maps[mapHeight-1][mapWidth-1];

	}
}