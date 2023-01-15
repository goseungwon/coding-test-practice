package doit.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int inputAmount = Integer.parseInt(br.readLine());
		int[] array = new int[inputAmount];

		for (int i=0; i<inputAmount; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		for (int i=inputAmount-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (array[j] > array[j+1] ) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}

		for (int num:array) {
			sb.append(num+"\n");
		}
		System.out.println(sb);
	}
}
