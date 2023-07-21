package doit.search;

import java.util.ArrayList;
import java.util.Scanner;

public class Backjoon13023 {
	static ArrayList<Integer>[] arr;
	static boolean[] isVisited;
	static boolean isArrived;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int node = scanner.nextInt();
		int edge = scanner.nextInt();
		isVisited = new boolean[node];

		arr = new ArrayList[node];

		for (int i=0; i<node; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i=0; i<edge; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();

			arr[a].add(b);
			arr[b].add(a);
		}

		for (int i=0; i<node; i++) {
			dfs(i,1);
			if (isArrived) {
				break;
			}
		}

		if (isArrived) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	private static void dfs(int node, int depth) {
		if (depth == 5) {
			isArrived = true;
			return;
		}

		isVisited[node] = true;

		for (int curr : arr[node]) {
			if (isVisited[curr]) {
				continue;
			}
			dfs(curr, depth+1);
		}

		isVisited[node] = false;
	}



}
