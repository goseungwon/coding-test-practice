package programmers.programmerstest;

import java.util.ArrayList;
import java.util.Scanner;

public class CodingTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String DESKTOP = "desktop";
        final String IP = "192.168.0.";
        ArrayList<String> arrayList = new ArrayList<>();

        int n = 2;
        boolean[] running = new boolean[n+1];
        int[] lastUsed = new int[255];
        String[] queries = new String[]
                //{"desktop1 request", "desktop2 request","desktop3 request", "desktop3 request", "desktop1 release", "desktop3 request"};
                {"desktop1 request", "desktop2 request", "desktop1 release", "desktop2 release", "desktop3 request", "desktop3 release", "desktop2 request", "desktop1 request"};

        for (int i=0; i< queries.length; i++){
            int desktopNum = Character.getNumericValue(queries[i].charAt(7));
            String cmd = queries[i].substring(9);


            if (cmd.equals("request")){
                int last = lastUsed[desktopNum];
                if (last>0){
                    if (!running[last]){
                        running[last] = true;
                        arrayList.add(DESKTOP + desktopNum + " " + IP + last);
                        continue;
                    }
                }


                for (int j=1; j<=n; j++) {
                    if (!running[j]) {
                        running[j] = true;
                        arrayList.add(DESKTOP + desktopNum + " " + IP + j);
                        //아이피추가
                        lastUsed[desktopNum] = j;
                        break;
                    }
                    if (j == n) {
                        arrayList.add(DESKTOP + desktopNum + " reject");
                        //수정해야함
                    }
                }
            }else if (cmd.equals("release")){
                running[lastUsed[desktopNum]]=false;
            }
        }
        String[] answer = new String[arrayList.size()];

        for (int i=0; i< arrayList.size(); i++){
            answer[i] = arrayList.get(i);
        }


    }
}


/*


import java.util.ArrayList;

class Solution {
    public String[] solution(int n, String[] queries) {
        final String DESKTOP = "desktop";
        final String IP = "192.168.0.";
        ArrayList<String> arrayList = new ArrayList<>();

        boolean[] running = new boolean[n+1];
        int[] lastUsed = new int[255];

        for (int i=0; i< queries.length; i++){
            int desktopNum = Character.getNumericValue(queries[i].charAt(7));
            String cmd = queries[i].substring(9);


            if (cmd.equals("request")){
                int last = lastUsed[desktopNum];
                if (last>0){
                    if (!running[last]){
                        running[last] = true;
                        arrayList.add(DESKTOP + desktopNum + " " + IP + last);
                        continue;
                    }
                }


                for (int j=1; j<=n; j++) {
                    if (!running[j]) {
                        running[j] = true;
                        arrayList.add(DESKTOP + desktopNum + " " + IP + j);
                        lastUsed[desktopNum] = j;
                        break;
                    }
                    if (j == n) {
                        arrayList.add(DESKTOP + desktopNum + " reject");
                    }
                }
            }else if (cmd.equals("release")){
                running[lastUsed[desktopNum]]=false;
            }
        }
        String[] answer = new String[arrayList.size()];

        for (int i=0; i< arrayList.size(); i++){
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}*/
