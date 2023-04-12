package programmers;

public class 선입_선출_스케줄링 {
	public int solution(int n, int[] cores) {
		int answer = 0, min = 0, max = cores[0] * n, time = 0, work = 0;

		while(min<=max) {
			int mid = (min+max) / 2;
			int count=cores.length;

				for (int i=0; i<cores.length; i++) {
					count += mid/cores[i];
				}

			if (count >= n) {
				max = mid-1;
				time = mid;
				work = count;
			} else {
				min = mid + 1;
			}
		}

		work-=n;
		for (int i= cores.length-1; i>=0; i--) {
			if (time % cores[i] == 0) {
				if (work == 0) {
					answer = i + 1;
					break;
				}
				work--;
			}
		}
		return answer;
	}
}
