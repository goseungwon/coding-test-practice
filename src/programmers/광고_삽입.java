package programmers;

public class 광고_삽입 {
	static int[] arr;
	static int answerTime = 0;
	static long count = 0;
	static long current=0;
	public String solution(String play_time, String adv_time, String[] logs) {
		int playTime = getTime(play_time);
		int advTime = getTime(adv_time);

		arr = new int[playTime+1];

		for (String log: logs) {
			setTime(log);
		}

		getFirst(0, advTime);

		for (int i=1; i<=playTime-advTime; i++) {
			bidTime(i, advTime);
		}

		return getTime(answerTime);
	}

	private void getFirst(int startTime, int advTime) {
		for (int i=startTime+1; i<=startTime + advTime; i++) {
			current += arr[i];
		}
		if (current>count) {
			count = current;
			answerTime = startTime;
		}
	}

	private void bidTime(int startTime, int advTime) {
		current -= arr[startTime];
		current += arr[startTime + advTime];

		if (current>count) {
			count = current;
			answerTime = startTime;
		}
	}

	private void setTime(String log) {
		int start = getTime(log.substring(0, 8));
		int end = getTime(log.substring(9));

		for (int i=start+1; i<=end; i++) {
			arr[i]++;
		}
	}

	private int getTime(String time) {
		return Integer.parseInt(time.substring(0, 2)) * 60 * 60
				+ Integer.parseInt(time.substring(3, 5)) * 60
				+ Integer.parseInt(time.substring(6));
	}

	private String getTime(int time) {
		int hour = time/(60 * 60);
		String hh = hour <10 ? "0" + hour : "" + hour;
		time -= (hour * 60 * 60);
		int minute = time/60;
		String mm = minute<10 ? "0" + minute : "" + minute;
		time -= (minute * 60);
		String ss = time<10 ? "0" + time : "" + time;

		return hh + ":" + mm + ":" + ss;
	}
}
