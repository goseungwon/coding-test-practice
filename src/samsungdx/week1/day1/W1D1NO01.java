package samsungdx.week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class W1D1NO01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testAmount = Integer.parseInt(br.readLine());

		for (int i=1; i<=testAmount; i++) {
			boolean[] numberArr = new boolean[11];
			int number = Integer.parseInt(br.readLine());
			int temp;
			int count=0;

			for (int n=1; ; n++) {
				temp = n * number;

				while (temp>0) {
					if (!numberArr[temp%10]) {
						numberArr[temp%10] = true;
						count++;
					}
					temp/=10;
				}
				if (count==10) {
					sb.append("#").append(i).append(" ").append(n*number).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
