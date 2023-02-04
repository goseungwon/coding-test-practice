package samsungdx.week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Connect implements Comparable<Connect> {
	long d;
	int from;
	int to;

	public Connect(long d, int from, int to) {
		super();
		this.d = d;
		this.from = from;
		this.to = to;
	}

	@Override
	public int compareTo(Connect o) {
		return Long.compare(this.d, o.d);
	}

}

public class 하나로 {
	static int number;
	static long total;
	static int[] parents;
	static double E;
	static long[] X;
	static long[] Y;
	static long[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testAmount = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= testAmount; testCase++) {
			number = Integer.parseInt(br.readLine());
			X = new long[number];
			Y = new long[number];
			dist = new long[number][number];
			parents = new int[number];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < number; i++) {
				X[i] = Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < number; i++) {
				Y[i] = Long.parseLong(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());

			for (int i = 0; i < number; i++)
				parents[i] = i;
			PriorityQueue<Connect> pq = new PriorityQueue<Connect>();
			for (int i = 0; i < number; i++) {
				for (int j = i + 1; j < number; j++) {
					if (i == j)
						continue;
					long L = (X[i] - X[j]) * (X[i] - X[j]) + (Y[i] - Y[j]) * (Y[i] - Y[j]);
					dist[i][j] = L;
					dist[j][i] = L;
					pq.offer(new Connect(L, i, j));
				}
			}
			int cnt = 0;
			total = 0;
			while (!pq.isEmpty()) {
				if (cnt == number - 1)
					break;
				Connect c = pq.poll();
				if (isUnion(c.from, c.to))
					continue;
				cnt++;
				total += c.d;

			}
			sb.append("#" + testCase + " " + Math.round(E * total) + "\n");
		}
		System.out.println(sb);
	}

	private static boolean isUnion(int from, int to) {
		int pf = find(from);
		int pt = find(to);
		if (pf == pt)
			return true;
		parents[(int)pf] = pt;
		return false;
	}

	private static int find(int x) {
		if (parents[x] == x)
			return x;
		else
			return parents[x] = find(parents[x]);
	}
}
