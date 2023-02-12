package samsungdx.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 힙 {

	static int[] heap;
	static int heapSize;
	static StringBuilder sb = new StringBuilder();

	public static void add(int input) {
		int index = ++heapSize;
		heap[index] = input;
		while (index > 1) {
			if (input > heap[index / 2]) {
				heap[index] = heap[index / 2];
				index = index / 2;
			} else {
				break;
			}
		}
		heap[index] = input;
	}

	public static void remove() {
		if (heapSize < 1) {
			sb.append("-1 ");
			return;
		}
		sb.append(heap[1] + " ");
		int target = heap[heapSize];
		heap[heapSize--] = 0;

		int index = 1;
		while (index * 2 <= heapSize) {
			int smallIdx = (heap[index * 2] > heap[index * 2 + 1]) ? index * 2 : index * 2 + 1;
			if (target < heap[smallIdx]) {
				heap[index] = heap[smallIdx];
				index = smallIdx;
			} else {
				break;
			}
		}
		heap[index] = target;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testAmount = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= testAmount; testCase++) {
			int inputAmount = Integer.parseInt(br.readLine());
			heap = new int[inputAmount + 1];
			heapSize = 0;
			sb.append("#" + testCase + " ");

			for (int i = 0; i < inputAmount; i++) {
			st = new StringTokenizer(br.readLine());
				switch (Integer.parseInt(st.nextToken())) {
					case 1:
						add(Integer.parseInt(st.nextToken()));
						break;
					case 2:
						remove();
						break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
