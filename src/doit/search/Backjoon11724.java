package doit.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Backjoon11724 {
	static ArrayList<Integer>[] arr;
	static boolean isVisited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");

		int node = Integer.parseInt(temp[0]);
		int edge = Integer.parseInt(temp[1]);

		arr = new ArrayList[node+1];
		isVisited = new boolean[node+1];

		for (int i=1; i<node+1; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i=0; i<edge; i++) {
			temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			arr[start].add(end);
			arr[end].add(start);
		}
		int count = 0;
		for (int i=1; i<node+1; i++) {
			if (!isVisited[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}
	private static void dfs(int value) {
		if (isVisited[value]) {
			return;
		}
		isVisited[value] = true;
		for (int i : arr[value]) {
			if (!isVisited[i]) {
				dfs(i);
			}
		}
	}
}
