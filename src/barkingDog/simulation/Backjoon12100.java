package barkingDog.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Backjoon12100 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int size;
	static int result;
	static int[][] input;
	static int[][] tempInput;

	public static void main(String[] args) throws IOException {
	  init();
	  solve();
	  print();
	}

	private static void init() throws IOException {
		size = Integer.parseInt(br.readLine());
		input = new int[size][size];
		tempInput = new int[size][size];

		for (int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<size; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void solve() {
		for (int search=0; search<1024; search++) {

			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					tempInput[i][j] = input[i][j];
				}
			}

			int searchNumber = search;
			for (int i=0; i<=4; i++) {
				int direction = searchNumber % 4;
				searchNumber /= 4;
				tilt(direction);
			}

			getResult();

		}
	}

	private static void getResult() {
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				result = Math.max(result, tempInput[i][j]);
			}
		}
	}

	private static void tilt(int direction) {
		while(direction-->0) {
			turn();
		}

		for (int i=0; i<size; i++) {
			int[] tilted = new int[size];
			int index = 0;

			for (int j=0; j<size; j++) {
				if (tempInput[i][j]==0) {
					continue;
				}

				if (tilted[index]==0) {
					tilted[index] = tempInput[i][j];
				} else if (tilted[index] == tempInput[i][j]) {
					tilted[index++] *= 2;
				} else {
					tilted[++index] = tempInput[i][j];
				}
			}

			for (int j=0; j<size; j++) {
				tempInput[i][j] = tilted[j];
			}
		}
	}

	private static void turn() {
		//90도 회전해서 반환
		int[][] turnedMap = new int[size][size];

		for (int i = 0; i< size; i++) {
			for (int j = 0; j< size; j++) {
				turnedMap[j][size-i-1] = tempInput[i][j];
			}
		}
		tempInput = turnedMap;
	}

	private static void print() {
		System.out.println(result);
	}
}
