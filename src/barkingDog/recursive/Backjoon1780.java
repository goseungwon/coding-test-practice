package barkingDog.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1780 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	static int minus1 = 0;
	static int zero = 0;
	static int plus1 = 0;
	static int[][] map;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void solve() {
		recursive(map.length, 0,0);
	}

	private static void recursive(int size, int height, int width) {
		if (size==1) {
			int current = map[height][width];
			if (current == 1) plus1++;
			if (current == 0) zero++;
			if (current == -1) minus1++;
			return;
		}

		int flag = 0;

		for (int i=height; i<height+size; i++) {
			for (int j=width; j<width+size; j++) {

				if (i==height && j==width) {
					flag = map[i][j];
				}

				if (map[i][j] != flag) {
					int size1 = size / 3;
					recursive(size1, height, width);
					recursive(size1, height + size1 , width);
					recursive(size1, height + 2 * size1, width);
					recursive(size1, height, width + size1);
					recursive(size1, height + size1, width + size1);
					recursive(size1, height + 2 * size1, width + size1);
					recursive(size1, height, width + 2 * size1);
					recursive(size1, height + size1, width + 2 * size1);
					recursive(size1, height + 2 * size1, width + 2 * size1);
					return;
				}
			}
		}
		if (flag == 1) plus1++;
		if (flag == 0) zero++;
		if (flag == -1) minus1++;
	}

	private static void print() {
		System.out.println(minus1);
		System.out.println(zero);
		System.out.println(plus1);
	}
}
