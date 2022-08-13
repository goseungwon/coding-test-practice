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
        StringBuilder sb = new StringBuilder();

        tc = Integer.parseInt(br.readLine());
        arr = new String[tc];

        for (int i=0; i<tc; i++){
            String input = br.readLine();
//            System.out.println("input = " + input);

            if (i==0) {
                arr[0]=input;
                continue;
            }
            arr[i]=input;

            for (int j=0; j<i; j++){
                if (arr[j]==null){continue;}
                if(input.length()<arr[j].length()){
                    insert(j);
                    arr[j]=input;
                    break;
                } else if (input.length()==arr[j].length()) {
                    if (input.equals(arr[j])) {arr[i]=null; break;}
                    else if (input.compareTo(arr[j])<0){
                        insert(j);
                        arr[j]=input;
                        break;
                    }
                }
            }
        }//tc
        for (int i=0; i<tc; i++){
            if (arr[i]!=null) sb.append(arr[i]+"\n");
        }
        System.out.println(sb);
    }
    public static void insert(int j){
        for (int i =tc-1; i>j; i--){
            arr[i]=arr[i-1];
        }
    }
}
