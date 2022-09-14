package sequence.No20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Backjoon1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<Integer>(); //덱
        int[] arr = new int[tc]; //뽑아야 할 인덱스
        int count = 0;

        for (int i=0; i<length; i++){
            deque.offer(i+1);
        }


        st = new StringTokenizer(br.readLine());
        for (int i=0; i<tc; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }


        for (int i=0; i<tc; i++){
            int targerIndex = deque.indexOf(arr[i]);
            int middleIndex = (int) Math.floor(deque.size()/2);

            if (targerIndex > middleIndex){
                for (int j=0; j<deque.size()-targerIndex; j++){
                    int temp = deque.pollLast();
                    deque.addFirst(temp);
                    count++;
                }
            }else{
                for (int j=0; j<targerIndex; j++){
                    int temp = deque.pollFirst();
                    deque.addLast(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
