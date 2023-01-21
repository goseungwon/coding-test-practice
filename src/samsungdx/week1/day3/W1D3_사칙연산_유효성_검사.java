package samsungdx.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class W1D3_사칙연산_유효성_검사 {
    static int treeLength;
    static int result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            treeLength = Integer.parseInt(br.readLine());
            result = 1;

            for (int i = 0; i < treeLength; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                char input = st.nextToken().charAt(0);
                if (st.hasMoreTokens()) {
                    if (isNumber(input)) result = 0;
                }
                else {
                    if (!isNumber(input)) result = 0;
                }
            }
            sb.append("#"+testCase+" "+result+"\n");
        }
        System.out.println(sb);
    }
    static boolean isNumber(char input) {
        return input >= '0' && input <= '9';
    }
}
