package programmers;

public class 기지국_설치 {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int cursor = 0;
		int current = 1;

		while(current <= n) {
			if(cursor < stations.length && stations[cursor] - w <= current) {
				current = stations[cursor] + w + 1;
				cursor++;
			} else {
				answer ++;
				current += 2 * w + 1;
			}
		}
		return answer;
	}
}