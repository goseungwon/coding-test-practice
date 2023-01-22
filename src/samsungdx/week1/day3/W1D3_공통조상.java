package samsungdx.week1.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class W1D3_공통조상 {
	static final int MAX = 10001;
	static int [] parent = new int[MAX];
	static int [][] child = new int[MAX][2];
	static int count;
	static boolean isFind;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testAmount = Integer.parseInt(br.readLine());
		int vertex, edge, number1, number2;
		for(int testCase = 1; testCase <= testAmount; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			number1 = Integer.parseInt(st.nextToken());
			number2 = Integer.parseInt(st.nextToken());

			insert(vertex);

			st = new StringTokenizer(br.readLine());
			int parentNode, childNode;
			for (int i=0; i<edge; i++) {
				parentNode = Integer.parseInt(st.nextToken());
				childNode = Integer.parseInt(st.nextToken());
				parent[childNode] = parentNode;
				if (child[parentNode][0]==0) child[parentNode][0] = childNode;
				else child[parentNode][1] = childNode;
			}

			sb.append("#"+testCase+" "+search(number1, 0, number2)+" "+count+"\n");
		}
		System.out.println(sb);
	}

	public static void insert(int vertex) {
		count = 0;
		isFind = false;

		for (int i=1; i<=vertex; i++) {
			parent[i] = 0;
			child[i][0] = 0;
			child[i][1] = 0;
		}
	}

	public static int search(int start, int skipChild, int target) {
		dfs(start, skipChild, target);

		if (!isFind) return search(parent[start], start, target);
		else return start;
	}

	public static void dfs(int start, int skipChild, int target) {
		if (start == skipChild) return;
		count++;
		for (int i=0; i<2; i++) {
			if (child[start][i] == 0) continue;
			if (child[start][i] == target) isFind = true;
			dfs(child[start][i], skipChild, target);
		}
	}
}