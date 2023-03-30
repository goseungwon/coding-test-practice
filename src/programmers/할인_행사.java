package programmers;

public class 할인_행사 {
	public static void main(String[] args) {

	}
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		int[] count = new int[number.length];

		for(int i=0; i<10; i++) {
			for (int j=0; j<want.length; j++) {
				if(discount[i].equals(want[j])) {
					count[j] ++;
					break;
				}
			}
		}

		if(number == count) answer++;

		for(int i=10; i<discount.length; i++) {
			for (int j=0; j<want.length; j++) {
				if(discount[i].equals(want[j])) {
					count[j] ++;
					break;
				}
			}
			for (int j=0; j<want.length; j++) {
				if(discount[i-10].equals(want[j])) {
					count[j] --;
					break;
				}
			}
			if(number == count) answer++;
		}



		return answer;
	}
}
