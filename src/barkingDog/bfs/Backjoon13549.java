package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon13549 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	static boolean[] isVisited = new boolean[200_001];
	static int results = Integer.MAX_VALUE;
	static int subin;
	static int sister;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st=new StringTokenizer(br.readLine());

		subin = Integer.parseInt(st.nextToken());
		sister = Integer.parseInt(st.nextToken());
	}

	private static void solve() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(subin, 0));

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			isVisited[node.index] = true;

			if (node.index == sister){
				results = Math.min(node.time, results);
				continue;
			}

			if(isValid(node.index*2)) {
				queue.add(new Node(node.index*2, node.time));
			}
			if(isValid(node.index+1)) {
				queue.add(new Node(node.index+1, node.time+1));
			}
			if(isValid(node.index-1)) {
				queue.add(new Node(node.index-1, node.time+1));
			}
		}

	}

	private static void print() {
		System.out.println(results);
	}

	private static boolean isValid(int index) {
		return index>=0 && index<=100_001 && !isVisited[index];
	}

	static class Node {
		int index;
		int time;

		public Node(int index, int time) {
			this.index = index;
			this.time = time;
		}
	}
}
