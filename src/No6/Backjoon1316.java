package No6;

import java.util.Scanner;

public class Backjoon1316 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int tc = s.nextInt();
        int count = 0;

        for (int i = 0; i < tc; i++) {
            String word = s.next();
            int len = word.length();
            String[] arr = new String[len];
            arr[0] = String.valueOf(word.charAt(0));

            int index =0;

            Loop1 :
            for (int j = 1; j < len; j++) {

                if (String.valueOf(word.charAt(j)).equals(arr[index])){
                    continue;
                }
                for (int k=0; k<index; k++){
                    if (arr[k].equals(String.valueOf(word.charAt(j)))){
                        count++;
                        break Loop1;
                    }
                }
                index++;
                arr[index]=String.valueOf(word.charAt(j));
            }
        }System.out.println(tc - count);

    }
}
