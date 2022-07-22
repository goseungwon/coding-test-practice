package sequence.No13.No12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon1620 {

    //2----------------------------2번 배열
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        String[] S = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            S[i] = br.readLine();
//        }
//
//        for (int i = 0; i < m; i++) {
//            String input = br.readLine();
//            if (isStringNumber(input)) { //숫자인지 확인
//                sb.append(S[Integer.parseInt(input)-1] + "\n");
//            } else {
//                for (int j=0; j<n; j++){
//                    if (S[j].equals(input)){
//                        sb.append(j+1+"\n");
//                    }
//                }
//            }
//        }
//        System.out.print(sb);
//    }
    public static boolean isStringNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
//}









    //1-----------------------------------해시맵

    static Map<String, Integer> S=new HashMap<>();
    static Map<Integer, String> I=new HashMap<>();
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());


        for (int i=0; i<n; i++){
            String name=br.readLine();
            S.put(name,i+1);
            I.put(i+1, name);
        }

        for (int i=0; i<m; i++){
            String input=br.readLine();
            if (!isStringNumber(input)){ //숫자인지 확인
                sb.append(S.get(input)+"\n");
            }else{
                sb.append(I.get(Integer.parseInt(input))+"\n");
            }
        }
        System.out.print(sb);
    }


    //value로 key값 찾기
    public static <K, V> K getKey(Map<K, V> S, V input){
        for (K key: S.keySet()){
            if (input.equals(S.get(key))){
                return key;
            }
        }
        return null;
    }
}