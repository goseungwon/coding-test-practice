import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingTest1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        String[] inputArr = input.split("");  //한글자씩 나누기

        String first = inputArr[0];
        String curr = first;
        int now = 0;
        int count = 1;

        int[] countArr = new int[inputArr.length];

        for (int i=1; i< inputArr.length; i++){
            if (curr.equals(inputArr[i])){
                count++;
            }else{
                curr=inputArr[i];
                countArr[now] = count;
                now++;
                count = 1;
            }

            if (i == inputArr.length-1){
                countArr[now] = count;
            }
        }
        sb.append(first);
        for (int i=0; i<=now; i++){
            char temp = (char) (countArr[i]+64);

            sb.append(temp);
        }
        System.out.println(sb);

    }
}

/*
class Solution {
    public String solution(String src){
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // String input = br.readLine();
        String input = src;

        String[] inputArr = input.split("");  //한글자씩 나누기

        String first = inputArr[0];
        String curr = first;
        int now = 0;
        int count = 1;

        int[] countArr = new int[inputArr.length];

        for (int i=1; i< inputArr.length; i++){
            if (curr.equals(inputArr[i])){
                count++;
                if (i == inputArr.length-1){
                    countArr[now] = count;
                }
            }else{
                curr=inputArr[i];
                countArr[now] = count;
                now++;
                count = 1;
            }
        }
        sb.append(first);
        for (int i=0; i<=now; i++){
            char temp = (char) (countArr[i]+64);

            sb.append(temp);
        }

        String answer = sb.toString();



        return answer;
    }
}*/
