package barkingDog.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon2606 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static List<Integer>[] arrayList;
	static boolean[] visited;
	static int result = 0;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int computerAmount = Integer.parseInt(br.readLine())+1;
		arrayList = new ArrayList[computerAmount];
		visited = new boolean[computerAmount];

		for (int i=0; i<computerAmount; i++) {
			arrayList[i] = new ArrayList<>();
		}

		int inputCount = Integer.parseInt(br.readLine());

		for (int i=0; i<inputCount; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arrayList[start].add(end);
			arrayList[end].add(start);
		}
	}

	private static void solve() {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.add(1);
		visited[1] = true;

		while(!stack.isEmpty()) {
			Integer current = stack.pop();

			for (int i : arrayList[current]) {
				if (visited[i]) {
					continue;
				}

				stack.add(i);
				visited[i] = true;
				result++;
			}
		}

	}

	private static void print() {
		System.out.println(result);
	}
}
