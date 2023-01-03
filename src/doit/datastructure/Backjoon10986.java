package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon10986 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int inputAmount = Integer.parseInt(st.nextToken());
    int divideValue = Integer.parseInt(st.nextToken());
    int[] inputArr = new int[inputAmount+1];
    long[] divideArr = new long[divideValue];
    long count = 0;

    st = new StringTokenizer(br.readLine());

    for (int i=1; i<inputAmount + 1; i++) {
      inputArr[i] = (inputArr[i-1] + Integer.parseInt(st.nextToken())) % divideValue;
      if (inputArr[i] == 0) count++;
      divideArr[inputArr[i]]++;
    }

    for (int i=0; i<divideValue; i++) {
      if (divideArr[i] > 1) count += (divideArr[i] * (divideArr[i]-1) / 2);
    }
    System.out.println(count);
  }
}
