package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon1865 {
	static int[] dist;
	static List<List<Road>> roads;
	static int nodeAmount, roadAmount, wormholeAmount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;


		int tc = Integer.parseInt(br.readLine());

		for (int i=0; i<tc; i++) {
			//각각의 테케 시작
			st = new StringTokenizer(br.readLine());
			nodeAmount = Integer.parseInt(st.nextToken());
			roadAmount = Integer.parseInt(st.nextToken());
			wormholeAmount = Integer.parseInt(st.nextToken());

			roads = new ArrayList<>();
			dist = new int[nodeAmount + 1];
			for (int j=0; j<=nodeAmount; j++) {
				roads.add(new ArrayList<>());
			}

			for (int j=0; j<roadAmount + wormholeAmount; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				if (j<roadAmount) {
					roads.get(start).add(new Road(end, cost));
					roads.get(end).add(new Road(start, cost));
				} else {
					roads.get(start).add(new Road(end, -cost));
				}

			}
			sb.append(check() ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}

	public static boolean check() {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1]=0;
		boolean update = false;

		for (int i=1; i<nodeAmount; i++) {
			update = false;

			for (int j=1; j<=nodeAmount; j++) {
				for (Road road : roads.get(j)) {
					if (dist[road.end]>dist[j] + road.cost) {
						dist[road.end] = dist[j] + road.cost;
						update = true;
					}
				}
			}

			if (!update) break;
		}
		if (update) {
			for (int i=1; i<=nodeAmount; i++) {
				for (Road road : roads.get(i)) {
					if (dist[road.end]>dist[i]+road.cost) return true;
				}
			}
		}
		return false;
	}


	static class Road {
		int cost, end;

		public Road(int end, int cost) {
			this.cost = cost;
			this.end = end;
		}
	}
}
