package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon1092 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int craineAmount = Integer.parseInt(br.readLine());
		int[] crane = new int[craineAmount];


		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<craineAmount; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}

		int boxAmount = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<boxAmount; i++) {
			box.add(Integer.valueOf(st.nextToken()));
		}

		box.sort(Comparator.reverseOrder());
		Arrays.sort(crane);

		if (crane[craineAmount-1] < box.get(0)) {
			System.out.println("-1");
			return;
		}
		int count = 0, index;

		while (!box.isEmpty()) {
				index = 0;
			for (int c=craineAmount-1; c>=0;) {

				if (index >= box.size()) break;
				if (box.get(index) <= crane[c]) {
					box.remove(index);
					c--;
					continue;
				}
				index++;
			}
			count++;
		}
		System.out.println(count);
	}
}
