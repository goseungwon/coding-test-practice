package sequence.No13.No2;

import java.util.Scanner;

public class Backjoon2884 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int M = scanner.nextInt();

        if(H==0&&M<45){
            H+=24;
        }
        if (M<45){
            H--;
            M+=15;
        }else M-=45;
        System.out.print(H + " " + M);
    }
}
