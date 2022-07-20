package No13;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        Integer square1=0, square2;
        Integer num1 = 0, num2 = 0;
        Integer sinput = 0;
        int high = 0, width;
        Map<Integer, Integer> map = new HashMap<>();
        boolean isFirstSecond = true;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());

            if (!map.containsKey(input1)||input1==next(num1)) {
                map.put(input1, input2);
            } else if (isFirstSecond) {
                square1= input2* map.get(next(input1));
                num1=input1;
                high=input2;
                isFirstSecond = false;
            }
        }

//        int high=Math.max(map.get(1), map.get(2));
//        int width=Math.max(map.get(3), map.get(4));

//        square1 = sinput * map.get(num1);

//        high = high*width - square1;

        square2 = (map.get(mirror(num1))-high)*map.get(next(mirror(num1)));
        System.out.println(square1);
        System.out.println(square2);

        bw.write(String.valueOf((square1+square2) * k));
        bw.flush();
        bw.close();
    }

    private static int next(int input) {
        switch (input) {
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 2;
        }
        return 0;
    }

    private static int mirror(int input) {
        if (input%2==0) return input-1;
        else return input+1;
    }

}
