package sequence;

import java.util.Arrays;
import java.util.Scanner;

public class Backjoon2096 {

	static int[][] max;
	static int[][] min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int inputRows = sc.nextInt();

		int[][] arr = new int[inputRows][3];
		max = new int[inputRows][3];
		min = new int[inputRows][3];
		for (int a[]:min)
			Arrays.fill(a, 1_000_000);

		for (int i=0; i<inputRows; i++) {
			for (int j=0; j<arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i=0; i<arr[0].length; i++) {
			max[0][i] = arr[0][i];
			min[0][i] = arr[0][i];
		}

		findMax(arr);
		findMin(arr);

		Arrays.sort(max[max.length-1]);
		Arrays.sort(min[min.length-1]);

		int maxResult = max[max.length-1][2];
		int minResult = min[min.length-1][0];

		System.out.println(maxResult + " " + minResult);
	}

	public static void findMax(int[][] arr) {
		for (int i=1; i< arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				max[i][j] = Math.max(max[i][j], max[i-1][j] + arr[i][j]);
				if (validateRow(j-1)) max[i][j] = Math.max(max[i][j], max[i-1][j-1] + arr[i][j]);
				if (validateRow(j+1)) max[i][j] = Math.max(max[i][j], max[i-1][j+1] + arr[i][j]);
			}
		}
	}

	public static void findMin(int[][] arr) {
		for (int i=1; i< arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				min[i][j] = Math.min(min[i][j], min[i-1][j] + arr[i][j]);
				if (validateRow(j-1)) min[i][j] = Math.min(min[i][j], min[i-1][j-1] + arr[i][j]);
				if (validateRow(j+1)) min[i][j] = Math.min(min[i][j], min[i-1][j+1] + arr[i][j]);
			}
		}
	}

	public static boolean validateRow(int row) {
		return row<3 && row>=0;
	}

}
