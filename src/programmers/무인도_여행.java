package programmers;

import java.util.*;

public class 무인도_여행 {
	static char[][] map;
	static boolean[][] isVisited;
	static final int move[] = {-1, 1, 0, 0};

	public List<Integer> solution(String[] maps) {
		List<Integer> answer = new ArrayList<>();
		map = new char[maps.length][maps[0].length()];
		isVisited = new boolean[maps.length][maps[0].length()];

		for(int i=0; i<maps.length; i++) {
			map[i] = maps[i].toCharArray();
		}

		for(int i=0; i<maps.length; i++) {
			for(int j=0; j<maps[0].length(); j++) {
				if(!isVisited[i][j] && map[i][j] != 'X') {
					answer.add(bfs(i,j));
				}
			}
		}

		if(answer.size() == 0) answer.add(-1);

		Collections.sort(answer);
		return answer;
	}

	private int bfs(int x, int y){
		int sum = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		isVisited[x][y] = true;

		while(!queue.isEmpty()){
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			sum += map[cx][cy]-'0';
			for(int i=0;i<4;i++){
				int movedX = cx + move[i];
				int movedY = cy + move[3-i];
				if(movedX < 0 || movedY < 0 || movedX >= map.length || movedY >= map[0].length) continue;
				if(!isVisited[movedX][movedY] && map[movedX][movedY] != 'X'){
					isVisited[movedX][movedY] = true;
					queue.offer(new int[]{movedX, movedY});
				}
			}
		}
		return sum;
	}
}
