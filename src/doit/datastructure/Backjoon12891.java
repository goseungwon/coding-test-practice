package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon12891 {
  static int[] checkedArr = new int[4];
  static int[] checkArr = new int[4];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int inputLength = Integer.parseInt(st.nextToken());
    int pwLength = Integer.parseInt(st.nextToken());

    char[] inputArr = new char[inputLength];
    int count = 0;

    inputArr = br.readLine().toCharArray();

    st = new StringTokenizer(br.readLine());
    for (int i=0; i<4; i++) {
      checkArr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i=pwLength-1; i<inputLength; i++) {
      int forward = i-pwLength+1;

      if (i == pwLength-1){
        for (int j = forward; j <= i; j++) {
          checkChar(inputArr[j]);
        }
      } else {
        checkChar(inputArr[i]);
        deCheckChar(inputArr[forward-1]);
      }
      if (valid()) count++;
    }
    System.out.println(count);
  }
  private static void checkChar(char input) {
    if (input=='A') checkedArr[0] ++;
    else if (input=='C') checkedArr[1] ++;
    else if (input=='G') checkedArr[2] ++;
    else if (input=='T') checkedArr[3] ++;
  }

  private static void deCheckChar(char input) {
    if (input=='A') checkedArr[0] --;
    else if (input=='C') checkedArr[1] --;
    else if (input=='G') checkedArr[2] --;
    else if (input=='T') checkedArr[3] --;
  }

  private static boolean valid() {
    for (int i=0; i< checkArr.length; i++) {
      if (checkedArr[i] < checkArr[i]) {
        return false;
      }
    }
    return true;
  }
}
