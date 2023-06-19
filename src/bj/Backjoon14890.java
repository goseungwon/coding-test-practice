package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon14890 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		int size = Integer.parseInt(temp[0]);
		int length = Integer.parseInt(temp[1]);
		int answer = size*2;

		int[][] map = new int[size][size];
		boolean[][] bridge = new boolean[size][size];

		for (int i=0; i<size; i++) {
			temp = br.readLine().split(" ");
			for (int j=0; j<size; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		//가로
		for (int i=0; i<size; i++) {
			loop:
			for (int j=1; j<size; j++) {
				//같은 경우
				if (map[i][j-1] == map[i][j]) continue;
				// 1 이상 차이
				else if (Math.abs(map[i][j-1] - map[i][j]) > 1){
					answer--;
					break;
				}
				// 1 줄어든 경우
				else if (map[i][j-1] - map[i][j] == 1){
					if (size < length+j) {
						answer--;
						break;
					}
					if (length==1) {
						if (bridge[i][j]) answer--;
						else bridge[i][j] = true;
					}
					for (int k=1; k<length; k++) {
						if (map[i][j] != map[i][j+k] || bridge[i][j+k]) {
							answer--;
							break loop;
						}
						bridge[i][j+k] = true;
					}
					j+=length-1;
					//1 늘어난 경우
				} else {
					if (j-length < 0) {
						answer--;
						break;
					}
					for (int k=1; k<=length; k++) {
						if (map[i][j-1] != map[i][j-k] || bridge[i][j-k]) {
							answer--;
							break loop;
						}
						bridge[i][j-k] = true;
					}
				}
			}
		}

		bridge = new boolean[size][size];

		//세로
		for (int i=0; i<size; i++) {
			loop:
			for (int j=1; j<size; j++) {
				//같은 경우
				if (map[j-1][i] == map[j][i]) continue;
					// 1 이상 차이
				else if (Math.abs(map[j-1][i] - map[j][i]) > 1){
					answer--;
					break;
				}
				// 1 줄어든 경우
				else if (map[j-1][i] - map[j][i] == 1){
					if (size < length+j) {
						answer--;
						break;
					}
					if (length==1)  {
						if (bridge[j][i]) answer--;
						else bridge[j][i] = true;
					}
					for (int k=1; k<=length; k++) {
						if (map[j][i] != map[j+k][i] || bridge[j+k][i]) {
							answer--;
							break loop;
						}
						bridge[j+k][i] = true;
					}
					j+=length-1;
					//1 늘어난 경우
				} else {
					if (j-length < 0) {
						answer--;
						break;
					}
					for (int k=1; k<=length; k++) {
						if (map[j-1][i] != map[j-k][i] || bridge[j-k][i]) {
							answer--;
							break loop;
						}
						bridge[j-k][i] = true;
					}
				}
			}
		}

		System.out.println(answer);

	}
}
