package barkingDog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Backjoon11003 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int L;
	static Deque<Node> deque = new LinkedList<>();

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());


	}

	private static void solve() throws IOException {
		st = new StringTokenizer(br.readLine());

		for (int i=0; i<N; i++) {
			// 입력 시작
			int current = Integer.parseInt(st.nextToken());

			if (!deque.isEmpty() && deque.peekFirst().index - 1 < i - L) {
				deque.removeFirst();
			}

			while (!deque.isEmpty() && deque.peekLast().value >= current) {
					deque.removeLast();
			}
			deque.add(new Node(i, current));

			bw.append(deque.peekFirst().value + " ");

		}

	}

	private static void print() throws IOException {
		bw.flush();
		bw.close();
	}
}

class Node {
	int index;
	int value;

	public Node(int index, int value) {
		this.index = index;
		this.value = value;
	}
}
