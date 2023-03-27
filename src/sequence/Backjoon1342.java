package sequence;

import java.util.Scanner;

public class Backjoon1342 {
	static char[] alphabet = new char[27];
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();

		for (int i=0; i<inputStr.length(); i++) {
			alphabet[inputStr.charAt(i)-'a']++;
		}

		dfs(0, "", inputStr.length());

		System.out.println(count);
	}

	public static void dfs(int index, String str, int length) {
		if (str.length() == length ) {
			count++;
			return;
		}

		for (int i=0; i< alphabet.length; i++) {
			if (alphabet[i] == 0) continue;
			if (str.length()>0) {
				if (i+'a'==str.charAt(str.length()-1)) continue;
			}
			alphabet[i] --;
			dfs(index+1, str + (char)(i+'a'), length);
			alphabet[i] ++;
		}
	}




}
