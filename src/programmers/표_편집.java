package programmers;

import java.util.*;

public class 표_편집 {
	class Temp {
		int tempIndex, tempValue;

		Temp(int index, int value) {
			this.tempIndex = index;
			this.tempValue = value;
		}
	}

	//n 노드 개수, k 첫 커서, cmd 명령어 집합
	public String solution(int n, int k, String[] cmd) {
		List<Integer> list = new LinkedList<>();
		List<Boolean> isDeleted = new ArrayList<>();

		Stack<Temp> stack = new Stack<>();

		//list setting
		for(int i=0; i<n; i++) {
			list.add(i);
			isDeleted.add(false);
		}

		int cursor = k;

		for(String command:cmd) {
			switch(command.charAt(0)) {
				case 'U':
					cursor -= command.charAt(2) - '0';
					break;

				case 'D':
					cursor += command.charAt(2) - '0';
					break;

				case 'C':
					stack.add(new Temp(cursor, list.get(cursor)));
					isDeleted.set(list.get(cursor), true);

					list.remove(cursor);
					if(cursor>=list.size()) cursor--;
					break;

				case 'Z':
					Temp temp = stack.pop();
					if (temp.tempIndex<= cursor) cursor++;
					isDeleted.set(temp.tempValue, false);
					list.add(temp.tempIndex, temp.tempValue);
					break;

			}
		}

		StringBuilder sb = new StringBuilder();
		for(Boolean b:isDeleted) {
			if(b) {
				sb.append("X");
				continue;
			}
			sb.append("O");
		}

		return sb.toString();
	}
}