package programmers;

public class Two118667 {
    public static void main(String[] args) {
        int[] queue1 = {1,1,1,8,10,9};
        int[] queue2 = {1,1,1,1,1,1};


        int num = solution(queue1,queue2);
        System.out.println(num);
    }
        public static int solution(int[] queue1, int[] queue2) {
            int answer = 0;

            int queueLength = queue1.length + queue2.length;

            int[] queueA = new int[queueLength];
            int[] queueB = new int[queueLength];

            int totalQA=0;
            int totalQB=0;
            int startQA=0;
            int startQB=0;
            int endQA=queue1.length;
            int endQB=queue2.length;

            for(int i=0; i<queue1.length; i++){
                queueA[i]=queue1[i];
                totalQA += queue1[i];
            }
            for(int i=0; i<queue2.length; i++){
                queueB[i]=queue2[i];
                totalQB += queue2[i];
            }


            while(true){
                if(answer >2*queueLength) return -1;

                if(totalQA == totalQB){
                    return answer;
                }else if(totalQA>totalQB){
                    //System.out.print("totalQA = " + totalQA);
                    //System.out.println("totalQB = " + totalQB);
                    // System.out.println("big A");
                    endQB = (endQB)%queueB.length;
                    startQA = (startQA)%queueA.length;
                    queueB[endQB] = queueA[startQA];

                    totalQB += queueA[startQA];
                    totalQA -= queueA[startQA];

                    queueA[startQA] = 0;

                    startQA++;
                    endQB++;

                    answer++;
                }else{
                    // System.out.print("totalQA = " + totalQA);
                    // System.out.println("totalQB = " + totalQB);
                    // System.out.println("big B");
                    endQA = (endQA)%queueA.length;
                    startQB = (startQB)%queueB.length;
                    queueA[endQA] = queueB[startQB];

                    totalQA += queueB[startQB];
                    totalQB -= queueB[startQB];

                    queueB[startQB] = 0;

                    startQB++;
                    endQA++;

                    answer++;
                }
            }
        }
    }
