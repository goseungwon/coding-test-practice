package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon1107 {
    static Map map = new HashMap();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int goal=input;
        int inputleng = String.valueOf(input).length();
        int num = Integer.parseInt(br.readLine());
        boolean updown=true;
        int count;

        //안되는 녀석들
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            int a = Integer.parseInt(st.nextToken());
            map.put(a, 0);
        }


        if (input==100){
            System.out.println(0);
            System.exit(0);
        }



            // 위로
            for (int i = inputleng-1; i >= 0; i--) {
                int temp = getTemp(input, i);
                   //자리수 얻기
                while(map.containsKey(temp)){
                    if (updown) {
                        input += Math.pow(10, i);
                        updown=false;
                    }else{
                        input -= Math.pow(10, i);
                    }
                    temp=getTemp(input,i);

                }
            }

            count=Math.abs(goal-input);
            input=goal;
            updown=false;


            //아래로
        for (int i = inputleng-1; i >= 0; i--) {
            int temp = getTemp(input, i);
            //자리수 얻기
            while(map.containsKey(temp)){

                if (updown){
                    input +=Math.pow(10,i);
                }else{
                    input -= Math.pow(10, i);
                    updown = true;
                }
                temp=getTemp(input,i);

            }
        }
        count = Math.min(count, Math.abs(goal-input));



        count+=inputleng;
        System.out.println("count = " + count);
    }


    

//입력 가능한 숫자인지 체크
    private static boolean isGood(int temp) {
            //자리수별 확인
            if (map.containsKey(temp)) {
                return false;
            }
        return true;
    }

    private static int getTemp(int input, int i){
        return (int) (input/Math.pow(10,i) %10 );
    }
}
