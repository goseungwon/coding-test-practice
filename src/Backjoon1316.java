import java.util.Scanner;

public class Backjoon1316 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int tc = s.nextInt();
        String[] arr;
        int count = 0;

        for (int i = 0; i < tc; i++) {
            String word = s.next();
            int len = word.length();
            arr = new String[len];
            arr[0] = String.valueOf(word.charAt(0));

            Loop1 :
            for (int j = 1; j < len; j++) {
                if (String.valueOf(word.charAt(j)) == String.valueOf(word.charAt(j-1))){
                    continue;
                }
                for (int k=0; k<j; k++){
                    if (arr[k] == String.valueOf(word.charAt(j))){
                        count++;
                        break Loop1;
                    }
                }

                arr[j]=String.valueOf(word.charAt(j));
            }
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);

        }System.out.println(tc - count);

    }
}
