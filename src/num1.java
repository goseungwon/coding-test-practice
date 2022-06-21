public class num1
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        //int[] arr ={1,2,3,3,3,3,4,4};
        int[] arr ={3,2,4,4,2,5,2,5,5};

        int[] returnarr = new int [50];
        int cousor=0;

        for (int j=1; j<100; j++){
            int count=0;
            for (int i=0; i<arr.length; i++){
                if(arr[i]==j)  count++;
            }
            if (count>1){
                returnarr[cousor] = count;
                cousor++;
            }
        }


        if(cousor>0){
            for(int k=0; k<returnarr.length; k++){
                if(returnarr[k]==0) break;
                System.out.println(returnarr[k]);

            }
        }else{
            System.out.println(-1);
        }
    }
}