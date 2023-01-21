package samsungdx.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class W1D3_사칙연산 {
	static String[] vertex;
	static int[][] edge;
	static int treeLength;
	static int[] visit;
	static Stack<Integer> stack;

	public static void op(String s) {
		if(s.equals("+")) {
			int a = stack.pop();
			int b = stack.pop();
			stack.push(b+a);
		}
		else if(s.equals("-")) {
			int a = stack.pop();
			int b = stack.pop();
			stack.push(b-a);
		}
		else if(s.equals("*")) {
			int a = stack.pop();
			int b = stack.pop();
			stack.push(b*a);
		}
		else if(s.equals("/")) {
			int a = stack.pop();
			int b = stack.pop();
			stack.push(b/a);
		}
		else {
			int num = Integer.parseInt(s);
			stack.push(num);
		}
	}

	public static void dfs(int x) {
		visit[x] = 1;

		for(int i = 1; i <= treeLength; i++) {
			if(edge[x][i] == 1 && visit[i] == 0)
				dfs(i);
		}
		op(vertex[x]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int testCase = 1; testCase <= 10; testCase++) {
			treeLength = Integer.parseInt(br.readLine());
			edge = new int[treeLength + 1][treeLength + 1];
			vertex = new String[treeLength +1];
			visit = new int[treeLength + 1];
			stack = new Stack<>();

			for(int i = 0; i < treeLength; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(tk.nextToken());
				vertex[from] = tk.nextToken();

				for(int j = 0; j < 2; j++) {
					if(tk.hasMoreTokens()) {
						int to = Integer.parseInt(tk.nextToken());
						edge[from][to] = 1;
					}
				}
			}
			dfs(1);
			sb.append("#" + testCase + " " + stack.pop()+"\n");
		}
		System.out.println(sb);
	}
}