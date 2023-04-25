package programmers;

public class 마법의_엘리베이터 {
	public int solution(int storey) {
		int answer = 0;

		while (storey != 0) {
			int temp = storey % 10;
			if (temp==5 && (storey/10)%10 >=5) {
				answer += (10 - temp);
				storey += (10 - temp);
			}
			else if (temp <= 5) {
				answer+= temp;
			} else {
				answer+= (10 - temp);
				storey += (10 - temp);
			}
			storey /=10;
		}
		return answer;
	}
}
