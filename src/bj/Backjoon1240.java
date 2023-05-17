package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon1240 {
	static List<List<Node>> nodes = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		int answerAmount = Integer.parseInt(st.nextToken());

		for (int i=0; i<=tc; i++) {
			nodes.add(new ArrayList<>());
		}

		for (int i=1; i<tc; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			nodes.get(start).add(new Node(end, distance));
			nodes.get(end).add(new Node(start, distance));
		}

		for (int i=0; i<answerAmount; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			boolean[] isVisited = new boolean[tc+1];
			isVisited[start] = true;
			find(start, end, 0, isVisited);
		}

		System.out.println(sb);
	}

	private static void find(int start, int end, int count, boolean[] isVisited) {
		if (start == end) {
			sb.append(count).append("\n");
			return;
		}

		List<Node> node = nodes.get(start);

		for (int i=0; i<node.size(); i++) {
			Node curr = node.get(i);

			if (!isVisited[curr.next]) {
				isVisited[curr.next] = true;
				find(curr.next, end, count + curr.distance, isVisited);
				isVisited[curr.next] = false;
			}
		}
	}

	static class Node {
		int next, distance;

		public Node(int next, int distance) {
			this.next = next;
			this.distance = distance;
		}
	}

}
