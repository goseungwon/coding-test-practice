package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon19532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] stringInput = br.readLine().split(" ");

		int[] input = new int[stringInput.length];

		for (int i=0; i<stringInput.length; i++) {
			input[i] = Integer.parseInt(stringInput[i]);
		}

		int a = input[0];
		int b = input[1];
		int c = input[2];
		int d = input[3];
		int e = input[4];
		int f = input[5];

		b *= d;
		c *= d;

		d *= -a;
		e *= -a;
		f *= -a;

		int y = (c+f) / (b+e);
		int x = (f - y * e) / d;

		System.out.println(x + " " + y);
	}
}
