package programmers;

public class 뒤에_있는_큰_수_찾기 {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];

		point:
		for (int i= numbers.length-2; i>=0; i--) {
			for (int j=i+1; j< numbers.length; j++) {
				if (numbers[i] < numbers[j]) {
					numbers[i+1] = numbers[j];
					answer[i] = numbers[j];
					continue point;
				}

				if (answer[j] == -1) {
					answer[i] = -1;
					continue point;
				}
			}
			if (answer[i]==0) answer[i]=-1;

		}
		answer[numbers.length-1] = -1;

		return answer;
	}
}