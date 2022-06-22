public class Backjoon4673 {
    public static void main(String[] args) {

        int[] arr = new int[10000];

        for (int i = 0; i<arr.length; i++)
            arr[i] = i+1;

        for (int i = 0; i<arr.length; i++){
            int n =0;
            n = (i+1)/1000 + ((i+1)/100)%10 + ((i+1)/10)%10 + (i+1)%10 + i+1;
            if (n<=arr.length)
            arr[n-1]=-1;
        }

        for (int i=0; i<arr.length; i++){
         if (arr[i]>0)
             System.out.println(i+1);
        }
    }
}
