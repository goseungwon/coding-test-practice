package bj;

import java.util.*;

public class Backjoon17135 {
		static int height;
		static int width;
		static int range;
		static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		range = sc.nextInt();
		int[][] arr = new int[height][width];

		//값 입력
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		//아처 위치
		List<int[]> archerPosition = getArcherPosition(width);

		//최고값 찾도록 순환
		for (int i=0; i<archerPosition.size(); i++) {
			defence(deepCopy(arr), archerPosition.get(i)[0],archerPosition.get(i)[1], archerPosition.get(i)[2]);
		}

		System.out.println(answer);
	}

	//배열 매번 새로 생성
	private static int[][] deepCopy(int[][] original) {
		int[][] newArr = new int[original.length][];
		for (int i=0; i< original.length; i++) {
			newArr[i] = Arrays.copyOf(original[i], original[i].length);
		}
		return newArr;
	}

	//
	private static void defence(int[][] arr, int archer1, int archer2, int archer3) {
		int kill = 0;
		for (int i=0; i<height; i++) {
			//여기서 가까운적 찾기
			int[] kill1 = find(arr, archer1, height-i);
			int[] kill2 = find(arr, archer2, height-i);
			int[] kill3 = find(arr, archer3, height-i);
			//사살
			if (kill1[0]!=1000) {
				arr[kill1[0]][kill1[1]] = 0;
				kill++;
			}
			if (kill2[0]!=1000 && arr[kill2[0]][kill2[1]]==1) {
				arr[kill2[0]][kill2[1]] = 0;
				kill++;
			}
			if (kill3[0]!=1000 && arr[kill3[0]][kill3[1]]==1) {
				arr[kill3[0]][kill3[1]] = 0;
				kill++;
			}
		}
		answer = Math.max(answer, kill);
	}

	private static int[] find(int[][] arr, int archer, int currentLine) {
		int[] shot = new int[]{1000, 1000};
		int distance = Integer.MAX_VALUE;

		for (int i=currentLine-1; i>=0; i--) {
			for (int j=0; j<width; j++) {
				if (arr[i][j]!=1) continue;
				int temp = (currentLine-i) + Math.abs(archer-j);

				if (distance>=temp && temp <=range) {
					if (distance==temp && shot[1] < j) continue;
					shot = new int[]{i,j};
					distance=temp;
				}
			}
		}
		return shot;
	}

	private static List<int []> getArcherPosition(int n) {
		List<int[]> list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				for (int k =j+1; k < n; k++) {
					list.add(new int[]{i,j,k});
				}
			}
		}
		return list;
	}
}
