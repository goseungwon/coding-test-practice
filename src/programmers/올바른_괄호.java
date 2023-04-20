package programmers;

public class 올바른_괄호 {
	public static void main(String[] args) {
		String s = "()()";
		solution(s);
	}
	static boolean solution(String s) {
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			if(String.valueOf(s.charAt(i)).equals("(")) count++;

			else {
				if(count>0) count--;
				else return false;
			}
		}
		if (count==0) return true;
		return false;
	}
}
