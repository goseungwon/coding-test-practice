package programmers;

import java.util.Arrays;

public class 예산_직접_풀어보기 {

	public static void main(String[] args) {
		int[] arr= new int[] {1, 3, 2, 5, 4};
		System.out.println(solution(arr, 9));
	}

	public static int solution(int[] d, int budget) {
		int count = 0;
		Arrays.sort(d);

		for (int i=0; i<d.length; i++) {
			if (budget < d[i]) {
				break;
			}
			budget -= d[i];
			count ++;
		}
		return count;
	}
}
