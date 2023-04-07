package bj;

import java.util.*;

public class Backjoon2143 {
	static long[] arr1, arr2;
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		long t = sc.nextLong();

		int arr1Length = sc.nextInt();
		arr1 = new long[arr1Length];
		makeArr(arr1);

		int arr2Length = sc.nextInt();
		arr2 = new long[arr2Length];
		makeArr(arr2);

		long[] sum1 = new long[(arr1.length * (arr1.length + 1)) / 2];
		long[] sum2 = new long[(arr2.length * (arr2.length + 1)) / 2];

		int index = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i; j < arr1.length; j++) {
				if (i==0) {
					sum1[index++] = arr1[j];
					continue;
				}
				sum1[index++] = arr1[j] - arr1[i-1];
			}
		}

		index = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = i; j < arr2.length; j++) {
				if (i==0) {
					sum2[index++] = arr2[j];
					continue;
				}
				sum2[index++] = arr2[j] - arr2[i-1];
			}
		}

		Arrays.sort(sum1);
		Arrays.sort(sum2);

		int left=0, right=sum2.length-1;
		long sum, answer=0;

		while(left<sum1.length && right>-1) {
			long s1 = sum1[left], s2 = sum2[right];
			sum = s1+s2;
			if (sum == t) {
				long ac=0, bc=0;

				while(left<sum1.length && s1 == sum1[left]) {
					left++;
					ac++;
				}

				while(right>-1 && s2 == sum2[right]) {
					right--;
					bc++;
				}

				answer += ac*bc;
			}
			if (sum>t) right--;
			if (sum<t) left++;

		}

		System.out.println(answer);
	}

	private static void makeArr(long[] arr) {
		arr[0] = sc.nextInt();
		for (int i = 1; i< arr.length; i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
	}
}
