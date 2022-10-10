package basic.recursion;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1759 {
    static int length;
    static int alpha;
    static char[] input;
    static char[] pwd;
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        alpha = Integer.parseInt(st.nextToken());
        input = new char[alpha];
        pwd = new char[length];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<alpha; i++){
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);

        makePwd(0, 0);
//        bw.flush();
//        bw.close();
        System.out.println(sb);
    }

    static void makePwd(int start, int count) throws IOException {
        if (count==length){
            if (valid()){
//                bw.write(String.valueOf(pwd) + "\n");
//                System.out.println(pwd);
                sb.append(String.valueOf(pwd)+"\n");
            }
            return;
        }

        for (int i=start; i<alpha; i++){
            pwd[count] = input[i];
            makePwd(i+1, count+1);
        }
    }

    static boolean valid(){
        int collection = 0;
        int consonant = 0;

        for (char al : pwd){
            if (al == 'a' || al == 'e' || al == 'i' || al == 'o' || al == 'u') {collection++;}
            else {consonant++;}
        }

        if (collection>=1 && consonant>=2) {return true;}
        else {return false;}
    }
}
