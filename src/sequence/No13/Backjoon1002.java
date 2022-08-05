package sequence.No13;

import java.util.Scanner;

public class Backjoon1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc;

        tc = sc.nextInt();

        for (int test = 0; test < tc; test++) {
            int x1, y1, x2, y2, r1, r2;

            x1 = sc.nextInt();
            y1 = sc.nextInt();
            r1 = sc.nextInt();

            x2 = sc.nextInt();
            y2 = sc.nextInt();
            r2 = sc.nextInt();

            double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
            distance = Math.sqrt(distance);

            if (distance==0 && r1==r2){
                sb.append(-1+"\n");
            }else if (distance> (double) r1+r2){
                sb.append(0 + "\n");
            } else if (distance== (double) r1+r2) {
                sb.append(1 + "\n");
            }else {
                if (distance==(double) Math.abs(r1-r2)){
                    sb.append(1 + "\n");
                }else if (distance < (double) Math.abs(r1-r2)){
                    sb.append(0 + "\n");
                }else {
                    sb.append(2 + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
