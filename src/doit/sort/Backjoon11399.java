package doit.sort;

import java.util.Scanner;

public class Backjoon11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int length = sc.nextInt();

		int[] arr = new int[length];
		int[] sortedArr = new int[length];

		for (int i=0; i<length; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i=1; i<length; i++) {
			int currentIndex = i;
			int currentValue = arr[i];

			for (int j=i-1; j>=0; j--) {
				if (arr[j] < arr[i]) {
					currentIndex = j+1;
					break;
				}
				if (j==0) {
					currentIndex = 0;
				}
			}

			for (int j=i; j>currentIndex; j--) {
				arr[j] = arr[j-1];
			}
			arr[currentIndex] = currentValue;
		}
		sortedArr[0] = arr[0];
		for (int i=1; i<length; i++) {
			sortedArr[i] = sortedArr[i - 1] + arr[i];
 		}
		int sum = 0;
		for (int i=0; i<length; i++) {
			sum += sortedArr[i];
		}
		System.out.println(sum);
	}
}
