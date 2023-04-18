package programmers;

import java.util.*;

public class 위장 {
	public int solution(String[][] clothes) {
		Arrays.sort(clothes, Comparator.comparing((String[] o) -> o[1]));
		int answer = 1;
		int count = 1;

		for (int i=1; i<clothes.length; i++) {
			if(clothes[i-1][1].equals(clothes[i][1])) {
				count++;
				continue;
			}
			answer = answer * (count+1);
			count = 1;
		}

		return (count+1) *answer - 1;
	}

	public int solution2(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();

		for (String[] clothe : clothes) {
			if (map.containsKey(clothe[1]))
				map.replace(clothe[1], map.get(clothe[1]) + 1);
			else
				map.put(clothe[1], 2);
		}

		int answer = map.values().stream().reduce(1, (a, b) -> a * b);

		return answer-1;
	}
}
