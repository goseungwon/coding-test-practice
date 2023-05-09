package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1068 {
	static int[] arr;
	static int[] branches;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		branches = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			if (temp!=-1) branches[temp]++;
		}

		delete(N, Integer.parseInt(br.readLine()));

		int count = 0;
		for (int i=0; i<N; i++) {
			if(branches[i]==0) count++;
		}
 		System.out.println(count);
	}

	private static void delete(int N, int deleteIndex) {
		if (arr[deleteIndex]!=-1) branches[arr[deleteIndex]]--;
		branches[deleteIndex]=-1;
		for (int i=0; i<N; i++) {
			if (arr[i]==deleteIndex) {
				delete(N, i);
			}
		}
	}
}