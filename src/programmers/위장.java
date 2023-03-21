package programmers;

import java.util.Arrays;
import java.util.Comparator;

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
}
