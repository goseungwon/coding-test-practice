package barkingDog.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Backjoon16964 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	static boolean result = true;
	static Queue<Integer> expectResults = new LinkedList<>();
	static boolean[] visited;
	static List<Integer>[] map;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		map = new ArrayList[N+1];
		visited = new boolean[N+1];

		for (int i=0; i<=N; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			map[start].add(end);
			map[end].add(start);
		}

		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			expectResults.add(Integer.valueOf(st.nextToken()));
		}
	}

	private static void solve() {
		if (expectResults.poll() != 1) {
			result = false;
		} else {
			isAvailable(1,0);
		}
	}

	private static void isAvailable (int current, int parent) {
		if (visited[current]) {
			return;
		}

		visited[current] = true;
		Set<Integer> set = new HashSet<>();

		for (Integer i : map[current]) {
			if (i != parent) {
				set.add(i);
			}
		}

		while (!set.isEmpty()) {
			Integer expectResult = expectResults.poll();
			if (set.contains(expectResult)) {
				set.remove(expectResult);
				isAvailable(expectResult, current);
			} else {
				result = false;
				return;
			}
		}
	}

	private static void print() {
		System.out.println(result ? 1 : 0);
	}
}
