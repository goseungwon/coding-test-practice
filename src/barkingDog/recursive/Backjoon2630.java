package barkingDog.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2630 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	static boolean[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				if (st.nextToken().equals("1")) map[i][j] = true;
			}
		}
	}

	private static void solve() {
		recursive(map.length, 0,0);
	}

	private static void recursive(int size, int height, int width) {
		if (size==0) {
			return;
		}
		boolean flag = map[height][width];

		for (int i=height; i<height+size; i++) {
			for (int j=width; j<width+size; j++) {
				if (flag != map[i][j]) {
					int half = size/2;

					recursive(half, height, width);
					recursive(half, height+half, width);
					recursive(half, height, width+half);
					recursive(half, height+half, width+half);
					return;
				}
			}
		}


		if (flag) blue++;
		else white++;
	}

	private static void print() {
		System.out.println(white);
		System.out.println(blue);
	}
}
