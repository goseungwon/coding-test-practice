package programmers;

public class 숫자_변환하기 {
	static int[] arr;
	static final int MAX_VALUE = Integer.MAX_VALUE;

	public int solution(int x, int y, int n) {
		arr = new int[y+1];

		for (int i=x+1; i<=y; i++) {
			int a = i / 2 > 0 && i % 2 == 0 && x <= i / 2 ? arr[i / 2] : MAX_VALUE;
			int b = i / 3 > 0 && i % 3 == 0 && x <= i / 3 ? arr[i / 3] : MAX_VALUE;
			int c = i - n >= x ? arr[i - n] : MAX_VALUE;
			int d = Math.min(a, Math.min(b, c));

			arr[i] = d < MAX_VALUE ? d + 1 : MAX_VALUE;
		}

		int answer = arr[y];
		if(answer==Integer.MAX_VALUE) answer = -1;

		return answer;
	}
}