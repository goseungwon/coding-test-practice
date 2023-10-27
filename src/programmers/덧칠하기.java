package programmers;

public class 덧칠하기 {
	public int solution(int n, int m, int[] section) {
		int answer = 0;
		int current = 0;

		for (int i=0; i<section.length; i++) {
			if(current > section[i]) {
				continue;
			}

			answer++;
			current = section[i] + m;
		}

		return answer;
	}
}
