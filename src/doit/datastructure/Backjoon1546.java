package doit.datastructure;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Backjoon1546 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int tc = sc.nextInt();
    int[] arr = new int[tc];
    float total = 0 ;

    for (int i=0; i<tc; i++) {
      arr[i] = sc.nextInt();
      total += arr[i];
    }
    int max = Arrays.stream(arr).max().getAsInt();

    System.out.println(total / max * 100 / tc);

  }
}
