package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon19532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] stringInput = br.readLine().split(" ");

		int[] input = new int[stringInput.length];

		for (int i = 0; i < stringInput.length; i++) {
			input[i] = Integer.parseInt(stringInput[i]);
		}

		int a = input[0];
		int b = input[1];
		int c = input[2];
		int d = input[3];
		int e = input[4];
		int f = input[5];

		int x = (c * e - b * f) / (a * e - b * d);
		int y = (c * d - a * f) / (b * d - a * e);

		System.out.println(x + " " + y);
	}
}
