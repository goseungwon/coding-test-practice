package sequence.No4;

import java.util.Scanner;

public class Backjoon10818 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int max=-1000000;
        int min=1000000;

        int num = s.nextInt();

        int[] arr = new int[num];

        for (int j=0; j<num; j++){
            arr[j]=s.nextInt();
        }




        for (int i=0; i<num; i++){
            if(arr[i]>max) max=arr[i];
            if(arr[i]<min) min=arr[i];
        }


        System.out.println(min + " " + max);


    }
}
