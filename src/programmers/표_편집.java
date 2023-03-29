package programmers;

import java.util.*;

public class 표_편집 {
	public class Temp {
		int preIndex, value, postIndex;

		public Temp(int pre, int value, int post) {
			this.preIndex = pre;
			this.value = value;
			this.postIndex = post;
		}
	}

	//n 노드 개수, k 첫 커서, cmd 명령어 집합
	public String solution(int n, int k, String[] cmd) {
		int[] pre = new int[n];
		int[] post = new int[n];

		// arr setting
		for (int i = 0; i < n; i++) {
			pre[i] = i - 1;
			post[i] = i + 1;
		}
		post[n - 1] = -1;

		Stack<Temp> stack = new Stack<>();

		StringBuilder sb = new StringBuilder("O".repeat(n));

		for (String command : cmd) {
			switch (command.charAt(0)) {
				case 'U' -> {
					int value = Integer.parseInt(command.substring(2));
					while (value-- > 0) {
						k = pre[k];
					}
				}

				case 'D' -> {
					int value = Integer.parseInt(command.substring(2));
					while (value-- > 0) {
						k = post[k];
					}
				}

				case 'C' -> {
					stack.push(new Temp(pre[k], k, post[k]));
					if (pre[k] != -1)
						post[pre[k]] = post[k];
					if (post[k] != -1)
						pre[post[k]] = pre[k];
					sb.setCharAt(k, 'X');

					if (post[k] != -1)
						k = post[k];
					else
						k = pre[k];
				}

				case 'Z' -> {
					Temp temp = stack.pop();
					if (temp.preIndex != -1)
						post[temp.preIndex] = temp.value;
					if (temp.postIndex != -1)
						pre[temp.postIndex] = temp.value;
					sb.setCharAt(temp.value, 'O');
				}

			}
		}

		return sb.toString();
	}
}