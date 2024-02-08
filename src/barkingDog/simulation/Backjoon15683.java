package barkingDog.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon15683 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int height;
	static int width;

	static int[][] map;
	static int[][] watching;
	static int result = Integer.MAX_VALUE;
	static List<CCTV> cctvs = new ArrayList<>();

	static class CCTV {
		int height;
		int width;
		int number;

		public CCTV(int height, int width, int number) {
			this.height = height;
			this.width = width;
			this.number = number;
		}
	}
	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		watching = new int[height][width];

		for (int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<width; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;

				if (input==6) {
					checkWall(i,j);
				} else if (input > 0){
					//cctv 리스트에 객체 만들어서 담기.
					cctvs.add(new CCTV(i,j,input));
				}
			}
		}
	}

	private static void solve() {
		// 5번 부터 채운다.
		checkFive();

		// 리스트에 담긴 cctv 위치를 dfs 한다.
		dfs(0);


	}

	private static void dfs(int index) {
		if (index == cctvs.size()) {
			countResult();
			return;
		}

		CCTV cctv = cctvs.get(index);

		//dfs하고, 개수세기
		for (int i=1; i<=4; i++) {
			cctv(cctv.height, cctv.width, cctv.number, i, true);
			dfs(index+1);
			cctv(cctv.height, cctv.width, cctv.number, i, false);
		}

	}

	private static void cctv(int height, int width, int number, int direction, boolean isPlus) {
		switch (number) {
			case 1 : cctvOne(height, width, direction, isPlus); return;
			case 2 : cctvTwo(height, width, direction, isPlus); return;
			case 3 : cctvThree(height, width, direction, isPlus); return;
			case 4 : cctvFour(height, width, direction, isPlus); return;
			default: return;
		}
	}



	private static void print() {
		System.out.println(result);
	}

	private static void checkWall(int height, int width) {
		watching[height][width] = -1;
	}

	private static void checkFive() {
		for (int i=0; i<cctvs.size(); i++) {
			CCTV cctv = cctvs.get(i);
			if (cctv.number==5) {
				cctvFive(cctv.height, cctv.width);
			}
		}

		cctvs.removeIf(cctv -> cctv.number==5);
	}

	private static void up(int height1, int width1, boolean isPlus) {
		for (int i=height1; i>=0; i--) {
			if (watching[i][width1]==-1) break;
			if (isPlus) watching[i][width1]++;
			else watching[i][width1]--;
		}
	}

	private static void right(int height1, int width1, boolean isPlus) {
		for (int i = width1; i < width; i++) {
			if (watching[height1][i] == -1) break;
			if (isPlus) watching[height1][i]++;
			else watching[height1][i]--;
		}
	}

	private static void down(int height1, int width1, boolean isPlus) {
		for (int i=height1; i<height; i++) {
			if (watching[i][width1]==-1) break;
			if (isPlus) watching[i][width1]++;
			else watching[i][width1]--;
		}
	}

	private static void left(int height1, int width1, boolean isPlus) {
		for (int i=width1; i>=0; i--) {
			if (watching[height1][i]==-1) break;
			if (isPlus) watching[height1][i]++;
			else watching[height1][i]--;
		}
	}

	private static void cctvOne(int height1, int width1, int direction, boolean isPlus) {
		switch (direction) {
			case 1: up(height1,width1, isPlus); return;
			case 2: right(height1, width1, isPlus); return;
			case 3: down(height1 ,width1, isPlus); return;
			case 4: left(height1, width1, isPlus); return;
		}
	}

	private static void cctvTwo(int height1, int width1, int direction, boolean isPlus) {
		switch (direction) {
			case 1: up(height1,width1, isPlus); down(height1,width1, isPlus); return;
			case 2: right(height1, width1, isPlus); left(height1,width1, isPlus); return;
			case 3: down(height1 ,width1, isPlus); up(height1,width1, isPlus); return;
			case 4: left(height1, width1, isPlus); right(height1,width1, isPlus); return;
		}
	}

	private static void cctvThree(int height1, int width1, int direction, boolean isPlus) {
		switch (direction) {
			case 1: up(height1,width1, isPlus); right(height1,width1, isPlus);  return;
			case 2: right(height1, width1, isPlus); down(height1,width1, isPlus); return;
			case 3: down(height1 ,width1, isPlus); left(height1,width1, isPlus); return;
			case 4: left(height1, width1, isPlus); up(height1,width1, isPlus); return;
		}
	}

	private static void cctvFour(int height1, int width1, int direction, boolean isPlus) {
		switch (direction) {
			case 1: up(height1,width1, isPlus); right(height1,width1, isPlus); down(height1,width1, isPlus); return;
			case 2: right(height1, width1, isPlus); down(height1,width1, isPlus); left(height1,width1, isPlus); return;
			case 3: down(height1 ,width1, isPlus); left(height1,width1, isPlus); up(height1,width1, isPlus); return;
			case 4: left(height1, width1, isPlus); up(height1,width1, isPlus); right(height1,width1, isPlus); return;
		}
	}

	private static void cctvFive(int height1, int width1) {
		up(height1,width1, true); right(height1,width1, true); down(height1,width1, true); left(height1, width1, true);
	}

	private static void countResult() {
		int count = 0;
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (watching[i][j] == 0) count++;
			}
		}

		result = Math.min(result, count);
	}

 }
