package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Backjoon11286 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> priorityQueueCustom = new PriorityQueue<>(
				(num1, num2) -> {
					int absoluteNum1 = Math.abs(num1);
					int absoluteNum2 = Math.abs(num2);
					if (absoluteNum1 == absoluteNum2) {
						return num1 > num2 ? 1 : -1;
					}else {
						return absoluteNum1 - absoluteNum2;
					}
				}
		);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int inputAmount = Integer.parseInt(br.readLine());

		for (int i=0; i<inputAmount; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input == 0) {
				if (priorityQueueCustom.isEmpty()) sb.append(0+"\n");
				else sb.append(priorityQueueCustom.poll()+"\n");
			} else {
				priorityQueueCustom.add(input);
			}
		}
		System.out.println(sb);
	}
}
