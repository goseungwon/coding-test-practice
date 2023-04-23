package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Backjoon21941 {
	static class Node{
		double efficiency;
		int score;
		String str;

		public Node(double efficiency, int score, String str) {
			this.efficiency = efficiency;
			this.score = score;
			this.str = str;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder input = new StringBuilder();
		PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2.efficiency, o1.efficiency));


		input.append(br.readLine());
		int length = Integer.parseInt(br.readLine());

		int answer = 0;
		for (int i=0; i<length; i++) {
			st = new StringTokenizer(br.readLine());
			String tempStr = st.nextToken();
			int tempScore = Integer.parseInt(st.nextToken());
			if (tempStr.length() >= tempScore) continue;
			queue.add(new Node((double)tempStr.length() / tempScore, tempScore, tempStr));
		}

			while(!queue.isEmpty()) {
				Node curr = queue.poll();
				while(true) {
					int temp = input.indexOf(curr.str);
					if (temp==-1) break;
					answer+= curr.score - 1;
					input.delete(temp, temp + curr.str.length());
					input.insert(temp, "0");
				}
			}

		System.out.println(answer + input.length());
	}
}
