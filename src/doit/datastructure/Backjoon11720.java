package doit.datastructure;

import java.util.Scanner;

public class Backjoon11720 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int tc = Integer.parseInt(sc.nextLine());
    int total = 0;
    String input = sc.nextLine();
    char[] arr = input.toCharArray();

    for (int i = 0; i<tc; i++) {
      arr[i] = input.charAt(i);
      total += arr[i] - '0';
    }

    System.out.println(total);
  }
}
