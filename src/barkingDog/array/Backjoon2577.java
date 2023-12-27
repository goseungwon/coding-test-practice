package barkingDog.array;

import java.util.Scanner;

public class Backjoon2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int result = A * B * C;

		int[] resultArray = new int[10];

		while (result > 0) {
			resultArray[result%10] += 1;

			result /= 10;
		}

		for (int i=0; i<resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
	}
}
