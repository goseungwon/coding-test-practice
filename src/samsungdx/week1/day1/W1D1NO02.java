package samsungdx.week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class W1D1NO02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testAmount = Integer.parseInt(br.readLine());

		for (int i=1; i<=testAmount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String M = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
			sb.append("#").append(i).append(" ");

			if (!(M.length()>=N)) { sb.append("OFF\n"); continue;}

			String binary = Integer.toBinaryString((int)Math.pow(2, N)-1);

			if (M.substring(M.length()-N).equals(binary)) sb.append("ON\n");
			else sb.append("OFF\n");
		}
		System.out.println(sb);
	}
}
