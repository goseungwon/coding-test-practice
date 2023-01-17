package samsungdx.week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class W1D1NO03 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int currentCase = 1; currentCase <= testCase; currentCase++) {
			String keys = br.readLine();
			int[][] cases = new int[keys.length()][16];

			first_day(keys, cases);
			for (int i = 1; i < keys.length(); i++) {
				findCases(keys, cases, i);
			}
			int ans = sol(cases);
			sb.append("#"+currentCase+" "+ans+"\n");
		}
		System.out.println(sb);
	}

	public static void first_day(String keys, int[][] dp) {
		int key = 1 << (keys.charAt(0) - 'A');
		for (int i = 1; i < 16; i++) {
			if ((i & key) != 0 && (i & 1) != 0) dp[0][i] = 1;
		}
	}
	public static void findCases(String keys, int[][] dp, int day) {
		int key = 1 << (keys.charAt(day) - 'A');
		for (int i = 1; i < 16; i++) {
			if (dp[day - 1][i] != 0) {
				for (int j = 1; j < 16; j++) {
					if ((j & i) != 0 && (j & key) != 0){
						dp[day][j] += dp[day - 1][i];
						dp[day][j] %= 1000000007;
					}
				}
			}
		}
	}
	public static int sol(int[][] dp){
		int sum = 0;
		for (int i = 1; i < 16; i++){
			sum += dp[dp.length-1][i];
			sum %= 1000000007;
		}
		return sum;
	}
}
