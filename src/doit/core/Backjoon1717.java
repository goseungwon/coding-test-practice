package doit.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1717 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        arr = new int[num+1];

        for (int i=0; i<arr.length; i++){
            arr[i] = i;
        }

        for (int i=0; i<tc; i++){
            st = new StringTokenizer(br.readLine());
            int doit = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());


            if (doit==0){
                union(first, second);
//                System.out.println(arr[first] + " " + arr[second]);
            }else{
                if (find(first) == find(second)) {
                    System.out.println("YES");
                }else System.out.println("NO");
            }
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a<b){
            arr[b] = a;
        }else{
            arr[a] = b;
        }
    }

    public static int find(int a){
        if (a==arr[a]) return a;
        else return arr[a] = find(arr[a]);
    }


}
