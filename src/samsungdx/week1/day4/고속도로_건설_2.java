package samsungdx.week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int from, to, cost;

	public Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge target) {
		return this.cost - target.cost;
	}
}

public class 고속도로_건설_2 {
	static int city, road;
	static int[] parent;
	static PriorityQueue<Edge> priorityQueue;
	static List<Edge> mstPath;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testAmount = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= testAmount; testCase++) {
			city = Integer.parseInt(br.readLine());
			parent = new int[city + 1];

			for (int i = 1; i <= city; i++) {
				parent[i] = i;
			}

			road = Integer.parseInt(br.readLine());
			priorityQueue = new PriorityQueue<>();

			for (int i = 1; i <= road; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				priorityQueue.add(new Edge(from, to, cost));
			}

			mstPath = new ArrayList<>();
			kruskal();
			int costSum = 0;

			for (int i = 0; i < mstPath.size(); i++) {
				costSum += mstPath.get(i).cost;
			}
			sb.append("#" + testCase + " " + costSum + "\n");
		}
		System.out.println(sb);
	}

	private static void kruskal() {
		for (int i = 1; i <= road; i++) {
			Edge edge = priorityQueue.poll();
			int a = find(edge.from);
			int b = find(edge.to);

			if (a != b) {
				union(a, b);
				mstPath.add(edge);
			}
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	private static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}
}
