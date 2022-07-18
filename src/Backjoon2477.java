import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int small = 0;
        Map<Integer, Integer> map = new HashMap<>();
        boolean isFirstSecond = true;

        for (int i=0; i<6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input1= Integer.parseInt(st.nextToken());
            int input2= Integer.parseInt(st.nextToken());

            if (isFirstSecond) {
                if (!map.containsKey(input1)) {
                    map.put(input1, input2);
                } else {
                    switch (input1) {
                        case 1:
                            small = map.get(4) * input2;
                            break;
                        case 2:
                            small = map.get(3) * input2;
                            break;
                        case 3:
                            small = map.get(1) * input2;
                            break;
                        case 4:
                            small = map.get(2) * input2;
                            break;
                    }
                    isFirstSecond=false;
                }
            }
        }

        int high=Math.max(map.get(1), map.get(2));
        int width=Math.max(map.get(3), map.get(4));

        high = high*width - small;

        bw.write(high*k);
        bw.flush();
        bw.close();
    }
}
