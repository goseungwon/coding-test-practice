package bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon2412 {
	static int N, T;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = sc.nextInt();

		list = new ArrayList[200001];
		for (int i=0; i<200001; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[y].add(x);
		}

		for (int i=0; i<list.length; i++) {
			Collections.sort(list[i]);
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0,0));
		int answer = 0;

		while(!queue.isEmpty()) {
			int size = queue.size();

			for (int i=0; i<size; i++) {
				Node curr = queue.poll();
				if (curr.y==T) {
					System.out.println(answer);
					return;
				}

				for (int j=curr.y-2; j<=curr.y+2; j++) {
					if (j<0 || j>= 200001) continue;
					for (int k=0; k<list[j].size(); k++) {
						int nextX = list[j].get(k);
						if (curr.x+2<nextX) break;
						else if (curr.x-2>nextX) continue;

						list[j].remove(k);
						queue.add(new Node(nextX, j));
						k--;
					}
				}
			}
			answer++;
		}
		System.out.println(-1);

	}

	static class Node{
		int x,y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
