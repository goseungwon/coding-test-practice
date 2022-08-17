package sequence.No11;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Backjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[tc];

        int total = 0;
        boolean bool =false;
        int result = 0;
        int count=0;

        for (int i=0; i<tc; i++){
            int input = Integer.parseInt(br.readLine());
            total += input;
            arr[i]=input;
        }
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer key : arr){
            map.put(key, map.getOrDefault(key,0)+1);
            if (map.get(key) > count){
                count= map.get(key);
                bool = false;
                result=key;
            } else if (map.get(key)==count && !bool) {
                bool=true;
                result=key;
            }
        }

        System.out.println(Math.round((double)total/tc));
        System.out.println(arr[tc/2]);
        System.out.println(result);
        System.out.println(arr[tc-1] - arr[0]);
    }
}