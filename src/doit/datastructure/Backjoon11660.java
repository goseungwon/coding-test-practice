package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon11660 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int arrSize = Integer.parseInt(st.nextToken());
    int question = Integer.parseInt(st.nextToken());
    int[][] arr = new int[arrSize+1][arrSize+1];
    arr[0][0] = 0;

    //배열에 담기
    for (int i=1; i <= arrSize; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 1; j <= arrSize; j++) {
        int input = Integer.parseInt(st.nextToken());

        if (i == 1) {
          arr[0][j] = input;
          if (j == 1) {
            arr[i][0] = input;
            arr[i][j] = input;
            continue;
          }
        } else if (j == 1) {
          arr[i][0] = input;
        }
        if (i == 1 || j == 1) {
          arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
        } else {
          arr[i][j] = arr[i - 1][j] + arr[i][j - 1] + input - arr[i-1][j-1];
        }
      }
    }

    for (int i=0; i<=arrSize; i++) {
      arr[0][i] = 0;
      arr[i][0] = 0;
    }

    //계산하기
    for (int i=0; i<question; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int result = arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
      System.out.println(result);
    }
  }
}
