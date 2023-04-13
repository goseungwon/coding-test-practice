package programmers;

import java.util.*;

public class 연속_부분_수열_합의_개수 {
	public int solution(int[] elements) {
		Set<Integer> set = new HashSet<>();
		int length = elements.length;

		for (int front=0; front<length; front++) {
			int count = 0;
			for (int length2=0; length2<elements.length; length2++) {
				count+=elements[(front+length2)%length];
				set.add(count);
			}
		}
		return set.size();
	}
}
