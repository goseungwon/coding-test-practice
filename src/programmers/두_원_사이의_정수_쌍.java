package programmers;

public class 두_원_사이의_정수_쌍 {

	class Solution {
		public long solution(int r1, int r2) {
			//좌측 부터 큰 원 안의 점의 개수 더하기
			//작은 원 안의 개수 뺴기 (겹치는 점 제외)

			long result = findDot(r2, 0, true);
			for (int i = 1; i <= r2; i++) {
				//찾는 함수 *2
				result += findDot(r2, i, true) * 2;
			}

			result -= findDot(r1, 0, false);
			for (int i = 1; i < r1; i++) {
				//찾는 함수 *2
				result -= findDot(r1, i, false) * 2;
			}

			return result;
		}

		private long findDot(int size, int x, boolean isBig) {
			double distance = Math.pow(size, 2);
			distance -= Math.pow(x, 2);

			if (!isBig)
				distance--;

			long dotNum = (long)Math.floor(Math.sqrt(distance));

			return 1L + 2 * dotNum;
		}
	}
}
