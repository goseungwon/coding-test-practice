package programmers;

public class 연속된_부분_수열의_합 {
		public int[] solution(int[] sequence, int k) {
			int[] answer = new int[2];
			int length=1000000000;
			int end=0, start=0;
			int sum = sequence[0];
			int n = sequence.length;

			while(true) {
				if(sum==k && end-start <length) {
					length = end - start;
					answer[0] = start;
					answer[1] = end;
				}

				if(start==n && end==n) break;

				if(sum<=k && end<n) {
					end++;
					if(end<n) sum+=sequence[end];
				}  else {
					if(start<n) sum-=sequence[start];
					start++;
				}
			}
			return answer;
		}
}
