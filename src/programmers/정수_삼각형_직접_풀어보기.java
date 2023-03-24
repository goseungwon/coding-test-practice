package programmers;

import java.util.*;

public class 정수_삼각형_직접_풀어보기 {
		public int solution(int[][] triangle) {
			// int[][] arr = triangle.clone();
			int[][] arr = new int[triangle.length][triangle.length];
			arr[0][0] = triangle[0][0];

			for(int i=0; i<triangle.length -1; i++) {
				for(int j=0; j<triangle[i].length; j++) {
					if(arr[i][j] + triangle[i+1][j] > arr[i+1][j]) {
						arr[i+1][j] = arr[i][j] + triangle[i+1][j];
					}
					if(arr[i][j] + triangle[i+1][j+1] > arr[i+1][j+1]) {
						arr[i+1][j+1] = arr[i][j] + triangle[i+1][j+1];
					}
				}
			}
			Arrays.sort(arr[arr.length-1]);
			return arr[arr.length-1][arr.length-1];
		}
}
