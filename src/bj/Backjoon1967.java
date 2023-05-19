package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Backjoon1967 {
	static ArrayList<Node>[] tree;
	static int length, max=0, maxIndex=0;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(br.readLine());
		tree = new ArrayList[length+1];

		for (int i=0; i<=length; i++) tree[i] = new ArrayList<>();

		for (int i=0; i<length-1; i++) {
			String[] arr = br.readLine().split(" ");

			tree[Integer.parseInt(arr[0])].add(new Node(Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
			tree[Integer.parseInt(arr[1])].add(new Node(Integer.parseInt(arr[0]), Integer.parseInt(arr[2])));
		}

		isVisited = new boolean[length+1];
		isVisited[1] = true;
		dfs(1,0);

		isVisited = new boolean[length+1];
		isVisited[maxIndex] = true;
		dfs(maxIndex, 0);

		System.out.println(max);
	}

	private static void dfs(int index, int count) {
		if (max < count) {
			max = count;
			maxIndex = index;
		}

		for (Node node : tree[index]) {
			if (isVisited[node.index]) continue;
			isVisited[node.index] = true;
			dfs(node.index, count + node.count);
		}
	}

	static class Node {
		int index, count;

		public Node(int index, int count) {
			this.index = index;
			this.count = count;
		}
	}
}
