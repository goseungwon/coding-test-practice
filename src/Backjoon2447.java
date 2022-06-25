import java.util.Scanner;

public class Backjoon2447 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        star(n);

    }

    public static void star(int n){
        if (n/3==1) {
            System.out.print("*");
        }

        if (n>0) {
            star(n / 3);
            star(n / 3);
            star(n / 3);
            System.out.println();
            star(n / 3);
            space(n);
            star(n / 3);
            System.out.println();
            star(n / 3);
            star(n / 3);
            star(n / 3);
        }


    }

        public void one(){
            System.out.print("*");
            System.out.print("*");
            System.out.print("*");
        }

        public static void space(int n){
            for (int i=0; i<n; i++)
                System.out.print(" ");
            }
}
