package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon21941 {
	static class Node{
		int score;
		String str;

		public Node(int score, String str) {
			this.score = score;
			this.str = str;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Node> list = new ArrayList<>();

		String input = br.readLine();
		int length = Integer.parseInt(br.readLine());

		for (int i=0; i<length; i++) {
			st = new StringTokenizer(br.readLine());
			String tempStr = st.nextToken();
			int tempScore = Integer.parseInt(st.nextToken());
			list.add(new Node(tempScore, tempStr));
		}

		int[] dp = new int[input.length()+1];
		for (int i=0; i<input.length(); i++){
			dp[i+1] = Math.max(dp[i+1], dp[i] + 1);
			for (int j=0; j<length; j++) {
				Node curr = list.get(j);
				if (input.startsWith(curr.str, i)) dp[i + curr.str.length()] = Math.max(dp[i + curr.str.length()], dp[i] + curr.score);
			}
		}

		System.out.println(dp[input.length()]);
	}
}
