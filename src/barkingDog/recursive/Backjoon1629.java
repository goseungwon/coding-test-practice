package barkingDog.recursive;

import java.io.IOException;
import java.util.Scanner;

public class Backjoon1629 {
	static int A;
	static int B;
	static int C;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	}

	private static void init() throws IOException {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
	}

	private static void solve() {
		System.out.println(recursive(B));
	}

	private static long recursive (int b) {
		if (b==1) {
			return A % C;
		}

		long temp = recursive(b/2);

		if (b%2==1) {
			return (temp * temp % C) * A % C;
		}

		return temp * temp % C;
	}

}
