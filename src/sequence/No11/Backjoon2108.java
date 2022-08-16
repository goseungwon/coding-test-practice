package sequence.No11;

import java.io.*;
import java.util.Arrays;

public class Backjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[tc];

        int total = 0;
        int result=10000;
        int curCount=1;
        int count=0;
        boolean bool =false;

        for (int i=0; i<tc; i++){
            int input = Integer.parseInt(br.readLine());
            total += input;
            arr[i]=input;
        }
        Arrays.sort(arr);


        result = arr[0];

        for (int i = 1; i < tc; i++) {
            if (arr[i] == result) {
                curCount++;
            }else{
                result = arr[i];
                if (count<curCount){
                    count=curCount;
                    curCount=1;
                    bool=false;
                } else if (count==curCount && !bool) {
                    result=arr[i];
                    bool=true;
                }
            }



            /*if (arr[i] != arr[i - 1] || i == tc) {
                if (choib < choia) {
                    choib = choia;
                    result = arr[i];
                    bool = false;
                } else if (choia == choib && !bool) {
                    if (arr[i] < result) {
                        result = arr[i];
                        bool = true;
                    }else {
                        bool = true;
                    }
                }
                choia = 0;
            }*/
        }


//        System.out.println(total);

        System.out.println(Math.round((double)total/tc));
        System.out.println(arr[tc/2]);
        System.out.println(result);
        System.out.println(arr[tc-1] - arr[0]);
//        System.out.println(Arrays.toString(arr));
    }
}

