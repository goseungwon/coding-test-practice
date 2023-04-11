package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split("");
		String[] arr2 = br.readLine().split("");
		String[] arr3 = br.readLine().split("");

		int[][][] count = new int[arr1.length+1][arr2.length+1][arr3.length+1];

		for (int i1=1; i1<arr1.length+1; i1++) {
			for (int i2=1; i2<arr2.length+1; i2++) {
				for (int i3 = 1; i3 < arr3.length+1; i3++) {
					if (arr1[i1-1].equals(arr2[i2-1]) && arr1[i1-1].equals(arr3[i3-1])) {
						count[i1][i2][i3] = count[i1-1][i2-1][i3-1] + 1;
						continue;
					}
					count[i1][i2][i3] = Math.max(Math.max(count[i1-1][i2][i3], count[i1][i2-1][i3]), count[i1][i2][i3-1]);
				}
			}
		}
		System.out.println(count[arr1.length][arr2.length][arr3.length]);
	}
}