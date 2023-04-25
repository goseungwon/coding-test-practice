package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon16235 {

	static class Node {
		int x,y, age;

		public Node(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] moveX = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
		int[] moveY = new int[]{1, -1, 0, 1, -1, 0, 1, -1};
		Deque<Node> tree = new LinkedList<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int year = Integer.parseInt(st.nextToken());

		int[][] ground= new int[N][N];
		int[][] A = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ground[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			tree.add(new Node(x,y,Integer.parseInt(st.nextToken())));
		}

		for (int a=0; a<year; a++) {
			Queue<Node> deadTree = new LinkedList<>();

			// spring();
			for (int i = 0; i< tree.size(); i++) {
				Node curr = tree.poll();
				if (curr.age <= ground[curr.x][curr.y]) {
					ground[curr.x][curr.y] -= curr.age;
					curr.age++;
					tree.add(curr);
				} else {
					deadTree.add(curr);
					i--;
				}
			}

			// summer();
			for (Node n : deadTree) {
				ground[n.x][n.y] += n.age/2;
			}

			// fall();
			Queue<Node> temp = new LinkedList<>();
			for (Node n : tree) {
				if (n.age % 5 == 0) temp.add(n);
			}
			while (!temp.isEmpty()) {
				Node n = temp.poll();
				for (int k=0; k<moveX.length; k++) {
					int dx=n.x + moveX[k];
					int dy=n.y + moveY[k];
					if (dx>=0 && dy>=0 && dx<N && dy<N) tree.addFirst(new Node(dx,dy,1));
				}
			}

			// winter();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ground[i][j] += A[i][j];
				}
			}

		}

		System.out.println(tree.size());
	}
}
