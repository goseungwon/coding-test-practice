package No2;

import java.time.LocalTime;
import java.util.Scanner;

public class Backjoon2525 {
    public static void main(String[] args) {
        //LocalTime now = LocalTime.now();
        Scanner s = new Scanner(System.in);

        //int H = now.getHour();
//        int M = now.getMinute();

        int H = s.nextInt();
        int M = s.nextInt();

//        System.out.println(H + " " + M);
        int p = s.nextInt();

        M=M+p;

        if (M>=60){
            H=H+M/60;
            M=M%60;
        }
        if (H>=24) H=H%24;

        System.out.println(H + " " + M);

    }
}
