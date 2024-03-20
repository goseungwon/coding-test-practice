package programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 석유_시추 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] asdf = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};

		solution.solution(asdf);
	}
	static class Solution {

		class Node {
			private final int y;
			private final int x;

			public Node(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}

		boolean visited[][];
		int resultSet[];
		static final int[] moveX = {1, -1, 0, 0};
		static final int[] moveY = {0, 0, 1, -1};

		g
}
