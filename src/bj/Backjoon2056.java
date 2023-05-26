package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2056 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int jobAmount = Integer.parseInt(br.readLine());
		int[] times = new int[jobAmount+1];
		int answer = 0;

		for (int i=1; i<=jobAmount; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			times[i] = time;
			int pre = Integer.parseInt(st.nextToken());

			for (int j=0; j<pre; j++) {
				int temp = Integer.parseInt(st.nextToken());

				times[i] = Math.max(times[i], times[temp] + time);
			}

			answer = Math.max(answer, times[i]);
		}
		System.out.println(answer);
	}
}
