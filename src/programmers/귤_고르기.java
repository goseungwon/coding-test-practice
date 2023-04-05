package programmers;

import java.util.Arrays;

public class 귤_고르기 {
	public static void main(String[] args) {
		int[] arr = {1,3,2,5,4,5,2,3};

		solution(6, arr);
	}
	public static int solution(int k, int[] tangerine) {
		int[] tangerineAmount = new int[10_000_001];

		Arrays.stream(tangerine)
				.forEach(t -> tangerineAmount[t]++);

		Arrays.sort(tangerineAmount);

		int answer = 0;
		int index = tangerineAmount.length;
		while (k>0) {
			k -= tangerineAmount[--index];
			answer++;
		}
		return answer;
	}
}
