package barkingDog.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon2164 {
	private static Scanner sc = new Scanner(System.in);
	private static int testCase;
	private static final Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		init();
		solve();
		print();
	}

	private static void solve() {
		while (queue.size() > 1) {
			queue.remove();
			queue.add(queue.remove());
		}
	}

	private static void print() {
		System.out.println(queue.poll());
	}

	private static void init() {
		testCase = sc.nextInt();

		for (int i=1; i<=testCase; i++) {
			queue.add(i);
		}
	}
}