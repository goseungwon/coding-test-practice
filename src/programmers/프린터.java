package programmers;

import java.util.*;

public class 프린터 {
	/* 1번 방법
	static class Node {
		int location, priority;

		public Node(int location, int priority) {
			this.location = location;
			this.priority = priority;
		}
	}

	public int solution(int[] priorities, int location) {
		Queue<Node> queue = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		int answer = 0;

		for(int i=0; i<priorities.length; i++) {
			queue.add(new Node(i, priorities[i]));
			list.add(priorities[i]);
		}

		list.sort(Collections.reverseOrder());

		while(!queue.isEmpty()) {
			if(queue.peek().priority == list.get(0)) {
				answer++;
				if(queue.peek().location == location) break;
				queue.poll();
				list.remove(0);
			}
			else queue.add(queue.poll());
		}
		return answer;
	}
	 */
	//2번
	public int solution(int[] priorities, int location) {
		List<Integer> list = new ArrayList<>();
		int answer = 0, count = 0;
		int size = priorities.length;

		for(int i=0; i<priorities.length; i++) {
			list.add(priorities[i]);
		}

		list.sort(Collections.reverseOrder());

		while(!list.isEmpty()) {
			if(priorities[count%size] == list.get(0)) {
				answer++;
				if(count%size == location) break;
				list.remove(0);
			}
			count++;
		}

		return answer;
	}
}