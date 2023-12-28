package barkingDog.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Top> inputs = new Stack<>();
		StringBuilder result = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i=1; i<=testCase; i++) {
			int input = Integer.parseInt(st.nextToken());

			if (inputs.empty()) {
				result.append(0);
			}

			if (!inputs.empty()) {
				while (!inputs.empty()) {
					Top currentTop = inputs.pop();

					if (currentTop.height > input) {
						result.append(currentTop.index);
						inputs.push(currentTop);
						break;
					}

					if (inputs.empty()) {
						result.append(0);
					}
				}

			}

			inputs.push(new Top(i, input));
			result.append(" ");
		}

		System.out.println(result);

	}

	static class Top {
		private int index;
		private int height;

		public Top(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
}
