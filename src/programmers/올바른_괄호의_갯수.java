package programmers;

import java.util.*;

public class 올바른_괄호의_갯수 {

	class P {
		int open, close;

		public P(int open, int close) {
			this.open = open;
			this.close = close;
		}
	}
	public int solution(int n) {
		int answer = 0;
		Stack<P> stack = new Stack<>();
		stack.add(new P(0, 0));

		while (!stack.isEmpty()) {
			P p = stack.pop();
			if (p.open>n) continue;
			if (p.open<p.close) continue;
			if (p.open + p.close == 2*n) {
				answer++;
				continue;
			}
			stack.add(new P(p.open+1, p.close));
			stack.add(new P(p.open, p.close+1));

		}
		return answer;
	}
}
