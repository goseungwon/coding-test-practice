package programmers;

import java.util.Arrays;

public class 숫자_게임_직접_풀어보기 {
	public static int solution(int[] a, int[] b) {
		int count = 0;
		int index = -1;

		Arrays.sort(a);
		Arrays.sort(b);

		for (int i = 0; i < a.length; i++) {

			while (index < a.length - 1) {
				if (a[i] < b[++index]) {
					count++;
					break;
				}

			}
		}
		return count;
	}
}

