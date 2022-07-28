package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon1107 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input= Integer.parseInt(br.readLine());
        int goal =input;
        int num= Integer.parseInt(br.readLine());
        int count=num;
        Map map = new HashMap();

        //안되는 녀석들
        StringTokenizer st = new StringTokenizer(br.readLine();
        for (int i=0; i<num; i++){
            map.put(st.nextToken(),0);
        }

        for (int i=num; i>0; i++) {
            int temp = input % (10 ^ i);

            if (temp==10){
                //자리수 바뀔때때
           }else {
                //자리수 안바뀔때
                if (map.containsKey(temp)) {

                }
            }
        }





    }
}
