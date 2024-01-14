package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon13549 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] map = new int[100_001];
	static boolean[] isVisited = new boolean[100_001];
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
		isVisited[subin] = true;

		while (!queue.isEmpty()) {
			Node node = queue.remove();

			if (node.index == sister){
				results = node.time;
				return;
			}

			if(isValid(node.index*2)) {
				queue.add(new Node(node.index*2, node.time));
				isVisited[node.index*2] = true;
			}
			if(isValid(node.index+1)) {
				queue.add(new Node(node.index+1, node.time+1));
				isVisited[node.index+1] = true;
			}
			if(isValid(node.index-1)) {
				queue.add(new Node(node.index-1, node.time+1));
				isVisited[node.index-1] = true;
			}
		}

	}

	private static void print() {
		System.out.println(results);
	}

	private static boolean isValid(int index) {
		return index>=0 && index<=100_000 && !isVisited[index];
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
