package barkingDog.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon15686 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int M;
	static Node[] chicken = new Node[13];
	static Node[] house = new Node[100];
	static boolean[] chickenVisited = new boolean[13];
	static int result = Integer.MAX_VALUE;
	static int indexChicken = 0;
	static int indexHouse = 0;

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 2) {
					chicken[indexChicken++] = new Node(i,j);
				} else if (input == 1) {
					house[indexHouse++] = new Node(i,j);
				}
			}
		}
	}

	private static void solve() {
		// 살아있는 치킨집 뽑아서 거리 재기
		combination(0, 0, M);
	}

	private static void combination(int start, int size, int max) {
		if (size==max) {
			//거리재기
			getDistance();
			return;
		}

		for (int i = start; i< indexChicken; i++) {
			chickenVisited[i] = true;
			combination(i+1, size+1, max);
			chickenVisited[i] = false;
		}
	}

	private static void getDistance() {
		int tempResult = 0;
		for (int i=0; i<indexHouse; i++) {
			Node tempHouse = house[i];

			int tempDistance = Integer.MAX_VALUE;
			for (int j=0; j<indexChicken; j++) {
				if (!chickenVisited[j]) continue;
				Node tempChicken = chicken[j];
				tempDistance = Math.min(tempDistance, (Math.abs(tempHouse.x - tempChicken.x) + Math.abs(tempHouse.y - tempChicken.y)));
			}
			tempResult += tempDistance;
		}

		result = Math.min(result, tempResult);
	}

	private static void print() {
		System.out.println(result);
	}
}
