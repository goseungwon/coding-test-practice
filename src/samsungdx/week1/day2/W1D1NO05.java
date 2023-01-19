package samsungdx.week1.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class W1D1NO05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testAmount = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int testCase = 1; testCase <= testAmount; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			List<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			while (N-- > 0)
				list.add(Integer.parseInt(st.nextToken()));

			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int idx, n;
				String cmd = st.nextToken();
				switch (cmd) {
					case "I":
						idx = Integer.parseInt(st.nextToken());
						n = Integer.parseInt(st.nextToken());
						list.add(idx, n);
						break;
					case "D":
						idx = Integer.parseInt(st.nextToken());
						list.remove(idx);
						break;
					case "C":
						idx = Integer.parseInt(st.nextToken());
						n = Integer.parseInt(st.nextToken());
						list.set(idx, n);
						break;
					default:
						break;
				}
			}

			int size = list.size() > L ? list.get(L) : -1;
			sb.append("#" + testCase + " " + size+"\n");
		}
		System.out.println(sb);
	}
}
