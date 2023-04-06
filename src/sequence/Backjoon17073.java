package sequence;

import java.util.*;

public class Backjoon17073 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testAmount = sc.nextInt();
		int rain = sc.nextInt();

		List<Integer>[] list = new ArrayList[testAmount+1];

		for (int i=1; i<testAmount+1; i++) {
			list[i] = new ArrayList<>();
		}


		for (int i=1; i<testAmount; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			list[second].add(first);
			list[first].add(second);
		}

		int leafAmount = 0;
		for (int i=2; i<list.length; i++) {
			if (list[i].size()==1) leafAmount++;
		}

		System.out.println((double)rain/leafAmount);

	}
}
