package sequence.No4;

import java.util.Scanner;


public class Backjoon4344 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        double[] result = new double[n];

         for (int i=0; i<n; i++) {
            int num = s.nextInt();
            int[] arr = new int[1001];
            double total = 0;

            for (int j = 0; j < num; j++) {
                arr[j] = s.nextInt();
                total += arr[j];
            }

            double count = 0;
            total = total/num;

            for (int k = 0; k < num; k++) {
                if (total < arr[k]) count++; //부등호 방향 하..
            }
            result[i]=(count/num)*100;
        }
         for(int i=0; i<n; i++)
             System.out.printf("%.3f%%\n",result[i]);
    }
}
