package doit.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();

		for (int i=1; i<=number; i++) {
			queue.add(i);
		}

		while (queue.size() != 1) {
			queue.remove();
			queue.add(queue.poll());
		}
		System.out.println(queue.peek());
	}
}
