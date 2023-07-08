package doit.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Backjoon1377 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N];

		for (int i=0; i<N; i++) {
			nodes[i] = new Node(i, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(nodes, (Comparator.comparingInt(o -> o.value)));

		int max = 0;
		for (int i=0; i<N; i++) {
			max = Math.max(nodes[i].index-i, max);
		}
		System.out.println(max+1);
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
