package doit.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Backjoon2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i=1; i<=number; i++) {
			deque.add(i);
		}

		while (deque.size() != 1) {
			deque.removeFirst();
			deque.add(deque.getFirst());
			deque.removeFirst();
		}
		System.out.println(deque.getFirst());
	}
}
