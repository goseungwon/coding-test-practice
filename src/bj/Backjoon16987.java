package bj;

import java.util.*;

public class Backjoon16987 {
	static int answer = 0;
	static int[][] eggs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int amount = sc.nextInt();
		eggs = new int[amount][2];

		for (int i = 0; i < amount; i++) {
			eggs[i][0] = sc.nextInt();
			eggs[i][1] = sc.nextInt();
		}

		dfs(0, 0);

		System.out.println(answer);
	}

	public static void dfs(int index, int result) {
		if (index == eggs.length) {
			answer = Math.max(result, answer);
			return;
		}
		if (eggs[index][0] <= 0 || eggs.length-1==result) {
			dfs(index + 1, result);
			return;
		}
		
		for (int i = 0; i < eggs.length; i++) {
			if (i == index || eggs[i][0] <= 0) continue;

			eggs[index][0] -= eggs[i][1];
			eggs[i][0] -= eggs[index][1];

			int temp = 0;
			if (eggs[index][0] <= 0) temp++;
			if (eggs[i][0] <= 0) temp++;

			dfs(index + 1, result + temp);

			eggs[index][0] += eggs[i][1];
			eggs[i][0] += eggs[index][1];
		}
	}
}
