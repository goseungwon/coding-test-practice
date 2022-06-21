import java.util.Scanner;

public class Backjoon1110 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int i, o, t, k;

        k=n;

        int count=0;

       do{


           o = k/10;
           t = k%10;
           i = t*10 + (o + t)%10;
           k = i;

           count++;
        }while(n != i);
        System.out.println(count);
    }
}
