package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 호텔_대실 {
	public int solution(String[][] book_time) {
		Arrays.sort(book_time, Comparator.comparing(a->a[0]));
		List<Integer> room = new ArrayList<>();
		int answer = 0;

		for(int i=0; i<book_time.length; i++) {
			String startString = book_time[i][0].replaceAll(":", "");
			String endString = book_time[i][1].replaceAll(":", "");

			int start = Integer.parseInt(startString);
			int end = Integer.parseInt(endString);

			for(int j=0; j<room.size(); j++) {
				if(room.get(j) <= start) {
					room.remove(j);
					j--;
				}
			}

			end += 10;
			if(end % 100 >= 60) {
				end += 40;
			}
			room.add(end);
			answer = Math.max(answer, room.size());
		}
		return answer;
	}
}
