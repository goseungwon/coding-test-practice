import java.util.Scanner;

public class Backjoon2941 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String word = s.next();
        String[] arr=new String[word.length()];
        int count=0;


        for (int i = 0; i < word.length(); i++) {
            arr[i] = String.valueOf(word.charAt(i));

            if (i>=1) {
                if (arr[i].equals("=")) {
                    if (i>=2)
                        if ((arr[i - 1].equals("z") && arr[i - 2].equals("d")))
                            count += 1;
                    if (arr[i - 1].equals("c") || arr[i - 1].equals("z") || arr[i - 1].equals("s"))
                        count++;
                }

                if (arr[i].equals("-")) {
                    if (arr[i - 1].equals("d") || arr[i - 1].equals("c"))
                        count++;
                }

                if (arr[i].equals("j")) {
                    if (arr[i - 1].equals("l") || arr[i - 1].equals("n"))
                        count++;
                }
            }
        }
        System.out.println(word.length()-count);
    }
}