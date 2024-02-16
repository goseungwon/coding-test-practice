package barkingDog.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon14891 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int GEAR_AMOUNT = 4;
	private static final int GEAR_SIZE = 8;
	// 각 톱니바퀴의 12시
	static int[] standardIndex = new int[GEAR_AMOUNT];
	static boolean[][] gears = new boolean[GEAR_AMOUNT][GEAR_SIZE];


	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {

		for (int i=0; i<GEAR_AMOUNT; i++) {
			String[] split = br.readLine().split("");

			for (int j = 0; j<GEAR_SIZE; j++) {
				if (split[j].equals("1")) {
					gears[i][j] = true;
				}
			}
		}
	}

	private static void solve() throws IOException {
		int caseCount = Integer.parseInt(br.readLine());

		for (int i=0; i<caseCount; i++) {
			st = new StringTokenizer(br.readLine());

			spin(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), true, true);
		}
	}

	private static void spin(int gearNumber, int direction, boolean left, boolean right) {
		int currentStandardIndex = standardIndex[gearNumber];
		if (gearNumber-1 >= 0 &&
				gears[gearNumber][(currentStandardIndex+6)%GEAR_SIZE] != gears[gearNumber-1][(standardIndex[gearNumber-1]+2)%GEAR_SIZE] &&
				left) {
			// 호출하고
			spin(gearNumber-1,-direction, true, false);
		}

		if (gearNumber+1 < 4 &&
				gears[gearNumber][(currentStandardIndex+2)%GEAR_SIZE] != gears[gearNumber+1][(standardIndex[gearNumber+1]+6)%GEAR_SIZE] &&
				right) {
			// 호출하고
			spin(gearNumber+1,-direction, false, true);
		}

		// 돌아간다.
			standardIndex[gearNumber] = (standardIndex[gearNumber] - direction + GEAR_SIZE) % GEAR_SIZE;
	}

	private static void print() {
		int result = 0;
		for (int i=0; i< GEAR_AMOUNT; i++) {
			if (gears[i][standardIndex[i]]) {
				result += (int)Math.pow(2, i);
			}
		}

		System.out.println(result);
	}
}
