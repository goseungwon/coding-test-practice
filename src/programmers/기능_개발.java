package programmers;

import java.util.*;

public class 기능_개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		int day = 0;
		List<Integer> list = new ArrayList<>();

		for(int i=0; i<progresses.length; i++) {
			int temp = 0;
			while(temp<100) {
				day++;
				temp = progresses[i] + speeds[i] * day;
			}

			int count = 1;
			for (int j=i+1; j<progresses.length; j++) {
				if(progresses[j] + speeds[j] * day < 100) break;
				count++;
				i++;
			}
			list.add(count);

		}
		int[] arr = new int[list.size()];
		for (int i=0; i<list.size(); i++) {
			arr[i] = list.get(i);
		}

		return arr;
	}
}