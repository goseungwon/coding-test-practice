package bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Backjoon1477 {
		static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int amount = sc.nextInt();
		int buildAmount = sc.nextInt();
		int highWay = sc.nextInt();

		// 휴게소 위치 받기
		for (int i=0; i<amount; i++) {
			list.add(sc.nextInt());
		}

		// 오름차순 정렬
		Collections.sort(list);

		// 제일 끝 휴게소 거리 추가
		list.add(highWay);

		// 휴게소간 거리 계산
		for (int i=amount; i>0; i--) {
			list.set(i, list.get(i) - list.get(i-1) -1);
		}
		list.set(0, list.get(0)-1);

		int left =1;
		int right = highWay;
		while (left<=right) {
			int mid = (left+right) / 2;
			if (count(mid)> buildAmount)  {
				left = mid + 1;
				continue;
			}
			right = mid - 1;
		}

		System.out.println(left);
	}


	private static int count(int distance) {
		int count=0;
		for (Integer integer : list) {
			count += integer / distance;
		}
		return count;
	}
}