package programmers;

import java.util.HashMap;
import java.util.Map;

public class 가장_가까운_같은_글자 {
	public int[] solution(String s) {
		int[] answer = new int[s.length()];

		Map<String, Integer> map = new HashMap<>();

		for(int i=0; i<s.length(); i++) {
			String word = String.valueOf(s.charAt(i));

			if(map.containsKey(word)) {
				answer[i] = i - map.get(word);
			}

			if(!map.containsKey(word)) {
				answer[i] = -1;
			}

			map.put(word, i);
		}

		return answer;
	}
}
