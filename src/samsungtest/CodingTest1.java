package samsungtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodingTest1 {
  static int line, row;
  static int[][] country;
  static boolean[] isVisit = new boolean[26];
  static int[] moveToX = { -1, 1, 0, 0 };
  static int[] moveToY = { 0, 0, -1, 1 };
  static int souvenir;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int testCase = Integer.parseInt(br.readLine());

    souvenir = 0;
    for (int test=0; test<testCase; test++) {
    StringTokenizer st = new StringTokenizer(br.readLine());

    line = Integer.parseInt(st.nextToken());
    row = Integer.parseInt(st.nextToken());
    country = new int[line][row];
    arrayInput(br);

    explore(0, 0, 0);
    sb.append("#" + (test+1) + " " + souvenir + "\n");
    }
    System.out.println(sb);
  }

  private static void arrayInput(BufferedReader br) throws IOException {
    for (int i = 0; i < line; i++) {
      String input = br.readLine();
      for (int j = 0; j < row; j++) {
        country[i][j] = input.charAt(j) - 'A';
      }
    }
  }

  public static void explore(int x, int y, int count) {
    if (isVisit[country[x][y]]) {
      souvenir = Math.max(souvenir, count);
    } else {
      isVisit[country[x][y]] = true;
      for (int i = 0; i < 4; i++) {
        int curX = x + moveToX[i];
        int curY = y + moveToY[i];

        if (curX >= 0 && curY >= 0 && curX < line && curY < row) {
          explore(curX, curY, count+1);
        }
      }
      isVisit[country[x][y]] = false;
    }
  }
}
