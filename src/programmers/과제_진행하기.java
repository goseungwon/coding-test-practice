package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

public class 과제_진행하기 {
}

class Solution {
	public String[] solution(String[][] plans) {
		Deque<Subject> stack = new ArrayDeque<>();
		List<String> answer = new ArrayList<>();
		Subject[] list = new Subject[plans.length];
		boolean doJob = false;

		for(int i=0; i<plans.length; i++) {
			list[i] = new Subject(
					plans[i][0],
					Integer.parseInt(plans[i][1].substring(0, 2)) * 60 + Integer.parseInt(plans[i][1].substring(3)),
					Integer.parseInt(plans[i][2]));
		}

		Arrays.sort(list, (Comparator.comparing(o -> o.time)));

		for (int i=0; i<list.length; i++) {
			if (stack.isEmpty()) {
				stack.push(list[i]);
				continue;
			}

			Subject current = stack.peek();
			Subject newSub = list[i];

			if (current.time + current.playtime <= newSub.time) {
				recursivePop(stack, newSub, current.time, answer);
			} else {
				current.playtime -= newSub.time - current.time;
			}
			stack.push(newSub);
		}

		while (!stack.isEmpty()) {
			answer.add(stack.pop().name);
		}
		return answer.toArray(new String[0]);
	}

	public void recursivePop(Deque<Subject> stack, Subject newSub, int currentTime, List<String> answer) {
		if (stack.isEmpty()) {
			return;
		}
		Subject current = stack.peek();   // 진행중 과제
		if (current.playtime + currentTime <= newSub.time) {
			answer.add(stack.pop().name);
			recursivePop(stack, newSub, currentTime + current.playtime, answer);
		} else {
			current.playtime -= newSub.time - currentTime;
		}
	}

	public class Subject {
		private String name;
		private int time;
		private int playtime;

		public Subject(String name, int time, int playtime) {
			this.name = name;
			this.time = time;
			this.playtime = playtime;
		}
	}
}
