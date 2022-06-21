import java.util.Scanner;

public class Backjoon4344 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int num;

        double[] resultarr = new double[n];
        int count=0;

        for (int i=0; i<n; n++){
            num=s.nextInt();
            int[] arr = new int[num];
            int total=0;
            for (int j=0; j<num; j++) {
                arr[j]=s.nextInt();
                total+=arr[j];
            }
            for(int j=0; j<num; j++){
                if(total/num>resultarr[j]) count++;
            }
            resultarr[i]=count/num;
            System.out.println(resultarr[0]);
        }

        for (int i=0; i<n; n++){
            System.out.println(resultarr[i]*100 + "%");
        }


    }
}
