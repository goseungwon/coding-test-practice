package barkingDog.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Backjoon1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		List<Integer> results = new LinkedList<>();


		for (int i=1; i<=N; i++) {
			list.add(i);
		}

		int cursor = 0;

		while (!list.isEmpty()) {
			cursor += K-1;
			cursor %= list.size();
			results.add(list.remove(cursor));
		}

		StringBuilder result = new StringBuilder();
		result.append("<");
		for (int i=0; i<results.size(); i++) {
			result.append(results.get(i));
			if (i < results.size() - 1) {
				result.append(", ");
			}
		}
		result.append(">");

		System.out.println(result);
	}
}
