package programmers;

import java.util.*;

public class 개인정보_수집_유효기간 {
	public static void main(String[] args) {

	}
	public int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		Arrays.stream(terms)
				.forEach(t ->
						map.put(t.charAt(0), Integer.parseInt(t.substring(2)))
				);

		Date todayDate = getDate(today);
		Calendar cal = Calendar.getInstance();

		for (int i=0; i<privacies.length; i++) {
			char yakgwan = privacies[i].charAt(11);

			Date tempDate = getDate(privacies[i]);
			cal.setTime(tempDate);
			cal.add(Calendar.MONTH, map.get(yakgwan));

			if (!todayDate.before(cal.getTime())) answer.add(i+1);
		}

		return answer.stream().mapToInt(i->i).toArray();
	}

	private static Date getDate(String privacies) {
		return new Date(Integer.parseInt(privacies.substring(0, 4)),
							Integer.parseInt(privacies.substring(5, 7)) -1,
							Integer.parseInt(privacies.substring(8, 10)));
	}
}
