package barkingDog.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Backjoon2448 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[][] map;

	private static final char star = '*';

	public static void main(String[] args) throws IOException {
	  init();
	  print();
	}

	private static void init() throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new char[N][2*N-1];
		for (int i=0; i<N; i++) {
			Arrays.fill(map[i], ' ');
		}
		solve(N, 0, N-1);
	}

	private static void solve(int size, int height, int width) {
		if (size==3) {
			map[height][width] = star;

			map[height+1][width-1] = star;
			map[height+1][width+1] = star;

			map[height+2][width-2] = star;
			map[height+2][width-1] = star;
			map[height+2][width] = star;
			map[height+2][width+1] = star;
			map[height+2][width+2] = star;

			return;
		}

		int halfSize = size / 2;
		solve(halfSize, height, width);
		solve(halfSize, height+ halfSize, width- halfSize);
		solve(halfSize, height+ halfSize, width+ halfSize);
	}

	private static void print() throws IOException {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}

		bw.close();
	}
}
