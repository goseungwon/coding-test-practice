package doit.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon1260 {
	private static ArrayList<Integer>[] graph;
	private static boolean[] isVisit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodeAmount = sc.nextInt();
		int edgeAmount = sc.nextInt();
		int startNode = sc.nextInt();

		graph = new ArrayList[nodeAmount+1];
		isVisit = new boolean[nodeAmount+1];

		for (int i=0; i<nodeAmount+1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i=0; i<edgeAmount; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			graph[start].add(end);
			graph[end].add(start);
		}

		for (int i=1; i<nodeAmount+1; i++) {
			Collections.sort(graph[i]);
		}

		dfs(startNode);
		System.out.println();
		isVisit = new boolean[nodeAmount+1];
		bfs(startNode);

	}

	private static void dfs(int current) {
		System.out.print(current + " ");
		isVisit[current] = true;

		for (int next : graph[current]) {
			if (isVisit[next]) {
				continue;
			}
			dfs(next);
		}
	}

	private static void bfs(int current) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(current);
		isVisit[current] = true;

		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr + " ");

			for (int next : graph[curr]) {
				if (isVisit[next]) {
					continue;
				}
				isVisit[next] = true;
				queue.add(next);
			}
		}
	}

}
