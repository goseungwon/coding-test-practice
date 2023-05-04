package programmers;

import java.util.*;

public class 롤케이크_자르기 {
	public int solution(int[] topping) {
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();

		for(int t : topping) {
			if(map2.containsKey(t)) map2.replace(t, map2.get(t) + 1);
			else map2.put(t, 1);
		}

		int answer = 0;
		for(int t: topping) {
			if(map1.containsKey(t)) map1.replace(t, map1.get(t) + 1);
			else map1.put(t, 1);

			map2.replace(t, map2.get(t) - 1);
			if (map2.get(t) == 0) map2.remove(t);

			if(map1.keySet().size() == map2.keySet().size()) answer++;
		}

		return answer;
	}
}
