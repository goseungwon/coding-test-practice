package sequence.No11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon1181{
    static int tc;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        arr = new String[tc];

        for (int i=0; i<tc; i++){
            String input = br.readLine();

            if (i==0) {
                arr[0]=input;
                break;
            }
            arr[i]=input;

            for (int j=0; j<tc; j++){
                if(input.length()<arr[j].length()){
                    insert(j);
                    arr[j]=input;
                    break;
                } else if (input.length()==arr[j].length()) {
                       if (input.compareTo(arr[j])>0){
                           insert(j);
                           arr[j]=input;
                           break;
                       }
                }
            }



        }//tc
        System.out.println(Arrays.toString(arr));
    }
    public static void insert(int i){
        for (int j =tc; j>i; j++){
            arr[j]=arr[j-1];
        }
    }
}
