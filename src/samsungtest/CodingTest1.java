package samsungtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodingTest1 {
  static int line, row;
  static int[][] country;
  static boolean[] isVisit = new boolean[26];
  static int[] move = { -1, 1, 0, 0 };
  static int souvenir;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int testCase = Integer.parseInt(br.readLine());

    for (int test=1; test<=testCase; test++) {
    souvenir = 1;
    isVisit = new boolean[26];
    StringTokenizer st = new StringTokenizer(br.readLine());

    line = Integer.parseInt(st.nextToken());
    row = Integer.parseInt(st.nextToken());
    country = new int[line][row];

    arrayInput(br);
    explore(0, 0, 0);
    sb.append("#").append(test).append(" ").append(souvenir).append("\n");
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
        int curX = x + move[i];
        int curY = y + move[3-i];

        if (curX >= 0 && curY >= 0 && curX < line && curY < row) {
          explore(curX, curY, count+1);
        }
      }
      isVisit[country[x][y]] = false;
    }
  }
}
