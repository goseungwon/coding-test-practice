package programmers;

public class 점_찍기 {
	public long solution(int k, int d) {
		final double range = Math.pow(d,2);
		long answer = 0;
		int curr = d;

		for (int i=0; i<=d; i+=k) {
			for (int j=curr; j>=0; j--) {
				if(Math.pow(i, 2) + Math.pow(j,2) <= range) {
					curr=j;
					answer += j/k + 1;
					break;
				}
			}
		}

		return answer;
	}
}
