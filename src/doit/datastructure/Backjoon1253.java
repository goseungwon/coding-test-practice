package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1253 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int inputAmount = Integer.parseInt(br.readLine());
    int[] inputArr = new int[inputAmount];
    int count = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<inputAmount; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(inputArr);

    for (int i=0; i<inputAmount; i++) {
      int forward = 0;
      int backward = inputAmount-1;

      while(backward>forward) {
        if (forward==i) {forward++; continue;}
        if (backward==i) {backward--; continue;}

        int sum = inputArr[forward] + inputArr[backward];
        if (sum == inputArr[i]) {
          count++;
          break;
        }
        else if (sum > inputArr[i]) {
          backward--;
        } else {
          forward++;
        }
      }

    }
    System.out.println(count);
  }

}
