package programmers;

import java.util.Arrays;

public class 가장_큰_수 {
	public String solution(int[] numbers) {
		//문자로 변환
		String[] strNums = new String[numbers.length];
		for (int i=0; i<numbers.length; i++) {
			strNums[i] = "" + numbers[i];
		}

		Arrays.sort(strNums, (o1, o2) -> (o2+o1).compareTo(o1+o2));


		StringBuilder sb = new StringBuilder();
		for (int i=0; i<numbers.length; i++) {
			sb.append(strNums[i]);
		}
		if (sb.charAt(0) == '0') {
			return "0";
		}

		return String.valueOf(sb);
	}
}
