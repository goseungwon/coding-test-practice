package doit.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon1167 {
	static ArrayList<Node>[] lists;
	static int[] distances;
	static boolean[] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int nodeAmount = Integer.parseInt(br.readLine());

		lists = new ArrayList[nodeAmount + 1];
		for (int i = 0; i < nodeAmount + 1; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 0; i < nodeAmount; i++) {
			st = new StringTokenizer(br.readLine());

			int startNode = Integer.parseInt(st.nextToken());
			while (true) {
				int endNode = Integer.parseInt(st.nextToken());
				if (endNode == -1) {
					break;
				}
				int distance = Integer.parseInt(st.nextToken());

				lists[startNode].add(new Node(endNode, distance));
				lists[endNode].add(new Node(startNode, distance));
			}
		}

		isVisit = new boolean[nodeAmount + 1];
		distances = new int[nodeAmount + 1];

		dfs(1);
		int[] arr = getMax(distances);

		isVisit = new boolean[nodeAmount + 1];
		distances = new int[nodeAmount + 1];

		dfs(arr[1]);
		System.out.println(getMax(distances)[0]);
	}

	private static int[] getMax(int[] arr) {
		int max = 0;
		int maxNode = 0;

		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				maxNode = i;
			}
		}
		return new int[] {max, maxNode};
	}

	private static void dfs(int current) {
		isVisit[current] = true;

		for (Node node : lists[current]) {
			if (isVisit[node.node]) {
				continue;
			}

			distances[node.node] += distances[current] + node.distance;
			dfs(node.node);
		}

	}

	public static class Node {
		private final int node;
		private final int distance;

		public Node(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}
}
