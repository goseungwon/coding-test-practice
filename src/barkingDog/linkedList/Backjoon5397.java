package barkingDog.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Backjoon5397 {
	public static void main(String[] args) throws IOException {
		/*
		백스페이스 -
		화살표 < / >
		나머진 글자 및 숫자
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder results = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int i=0; i<testCase; i++) {
			results.append(getPassword(br.readLine()));
			results.append("\n");
		}

		System.out.println(results);
	}

	private static String getPassword(String input) {
		List<Character> list = new LinkedList<>();
		ListIterator<Character> listIterator = list.listIterator();

		for (char current : input.toCharArray()) {

			if (current == '<') {
				if (listIterator.hasPrevious()) {
					listIterator.previous();
				}
			}

			else if (current == '>') {
				if (listIterator.hasNext()) {
					listIterator.next();
				}
			}

			else if (current == '-') {
				if (listIterator.hasPrevious()) {
					listIterator.previous();
					listIterator.remove();
				}
			}

			else {
				listIterator.add(current);
			}
		}

		StringBuilder result = new StringBuilder();
		for (Character character : list) {
			result.append(character);
		}

		return result.toString();
	}
}
