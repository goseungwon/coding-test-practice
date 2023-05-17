package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int answer = 0;

		int[] arr = new int[width];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<width; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
		}

		for (int i=1; i<width-1; i++) {
			int start=0, end=0;

			for (int j =0; j<i; j++) {
				start = Math.max(start, arr[j]);
			}
			for (int j =i+1; j<width; j++) {
				end = Math.max(end, arr[j]);
			}

			int min = Math.min(start, end);
			if (min > arr[i]) answer += min-arr[i];
		}

		System.out.println(answer);
	}
}
