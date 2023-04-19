package programmers;

import java.util.*;

public class 인사_고과 {
	public int solution(int[][] scores) {
		int[] wanHo = scores[0];
		Arrays.sort(scores, (score1, score2) -> (score2[0] + score2[1]) - (score1[0] + score1[1]));
		int answer = 1, current=Integer.MAX_VALUE, except = 0;

		for (int i=0; i<scores.length; i++) {
			//예외 사원 거르기
			if (check(scores[i], scores, i)) except++;

			if ((scores[i][0] + scores[i][1]) < current) {
				answer = i+1 - except;
				current = Math.min(current,(scores[i][0] + scores[i][1]));
			}
			if (scores[i] == wanHo) {
				if (check(wanHo, scores, i)) return -1;
				return answer;
			}
		}
		return answer;
	}

	public boolean check(int[] arr, int[][] scores, int index) {
		for (int i=0; i<index; i++) {
			if (arr[0] < scores[i][0] && arr[1] < scores[i][1]) return true;
		}
		return false;
	}
}
