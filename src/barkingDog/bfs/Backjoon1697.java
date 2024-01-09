package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1697 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int subin;
	static int dongsang;
	static int result;
	private static boolean[] isVisited = new boolean[100001];
	private static final int MAX = 100_000;
	private static final int MIN = 0;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		subin = Integer.parseInt(st.nextToken());
		dongsang = Integer.parseInt(st.nextToken());
	}

	private static void solve() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, subin));
		isVisited[subin] = true;

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			int current = node.index;

			if (current==dongsang) {
				result = node.time;
			}

			if (current + 1 <= MAX && !isVisited[current+1]) {
				queue.add(new Node(node.time + 1, current+1));
				isVisited[current+1] = true;
			}

			if (current - 1 >= MIN && !isVisited[current-1]) {
				queue.add(new Node(node.time + 1, current-1));
				isVisited[current-1] = true;
			}

			if (current*2 <= MAX && !isVisited[current*2]) {
				queue.add(new Node(node.time + 1, current*2));
				isVisited[current*2] = true;
			}

		}

	}

	private static void print() {
		System.out.println(result);
	}

	static class Node {
		private int time;
		private int index;

		public Node(int time, int index) {
			this.time = time;
			this.index = index;
		}
	}
}
