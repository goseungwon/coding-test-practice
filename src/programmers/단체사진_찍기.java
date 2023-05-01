package programmers;

public class 단체사진_찍기 {
	int answer = 0;
	public int solution(int n, String[] data) {
		String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
		permutation(friends, 0, data);

		return answer;
	}

	private void checkData(String[] arr, String[] datas) {
		for(String data: datas) {
			int i1=0, i2=0;
			for(int i=0; i<arr.length; i++) {
				if(String.valueOf(data.charAt(0)).equals(arr[i])) i1=i;
				if(String.valueOf(data.charAt(2)).equals(arr[i])) i2=i;
			}
			if (!compare(i1, i2, String.valueOf(data.charAt(3)), data.charAt(4)-'0')) return;
		}
		answer++;
	}

	private boolean compare(int s1, int s2, String com, int answer) {
		switch (com) {
			case "=":
				if (Math.abs(s1-s2)==answer+1) return true;
				break;
			case "<":
				if (Math.abs(s1-s2) < answer+1) return true;
				break;
			case ">":
				if (Math.abs(s1-s2) > answer+1) return true;
				break;
		}
		return false;
	}

	private void permutation(String[] arr, int depth, String[] data) {
		if(depth == arr.length) {
			checkData(arr, data);
		}

		for(int i=depth; i<arr.length; i++) {
			swap(arr,depth,i);
			permutation(arr, depth+1, data);
			swap(arr,depth,i);
		}
	}

	private void swap(String[] arr, int depth, int i) {
		String temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
}
