package programmers;

import java.util.HashMap;
import java.util.Map;

public class 대충_만든_자판 {
	public int[] solution(String[] keymap, String[] targets) {
		Map<String, Integer> map = new HashMap<>();

		for(String keys : keymap) {

			String[] temp = keys.split("");
			for(int i=0; i<temp.length; i++) {
				if(map.containsKey(temp[i])) {
					map.put(temp[i], (map.get(temp[i]) > i+1) ? i+1 : map.get(temp[i]));
				} else {
					map.put(temp[i], i+1);
				}
			}
		}

		int[] answer = new int[targets.length];

		loop:
		for(int i=0; i<targets.length; i++) {
			int count = 0;
			String target = targets[i];

			for(int j=0; j<target.length(); j++) {
				String word = String.valueOf(target.charAt(j));
				if(!map.containsKey(word)) {
					answer[i] = -1;
					continue loop;
				}
				count += map.get(word);
			}
			answer[i] = count;
		}

		return answer;
	}
}
