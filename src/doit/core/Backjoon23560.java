package doit.core;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Backjoon23560 {
	static Deque<Boolean> deque = new ArrayDeque<>();
	static int way = 1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dayCount = scanner.nextInt();
		int flag = 0;

		for (int i=0; i<dayCount; i++) {
			deque.add(true);
			deque.add(false);
			deque.add(true);
		}

		while (!deque.isEmpty()) {
			flag=(flag+1) %3;
			if (flag == 2) {
				lunch();
			}else {
				morning();
			}
		}
		System.out.println(way);
	}

	static void lunch() {
		if (!deque.getFirst() && !deque.getLast() && deque.size() != 1) {
			if (way%2==0) way = (int)(way*1.5);
			else way = way*2;
			deque.removeFirst();
		} else if (!deque.getFirst()) {
			deque.removeFirst();
		} else if (!deque.getLast()) {
			deque.removeLast();
		}
	}

	static void morning() {
		if (deque.getFirst() && deque.getLast() && deque.size() != 1) {
			if (way%2==0) way = (int)(way*1.5);
			else way = way*2;			deque.removeFirst();
		} else if (deque.getFirst()) {
			deque.removeFirst();
		} else if (deque.getLast()) {
			deque.removeLast();
		}
	}

}
