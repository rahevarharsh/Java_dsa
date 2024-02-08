public class KadanesAlgo {

    public static void kandanes_algo(int arr[]){
        int max_sum = Integer.MIN_VALUE;
        int sum =0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
            if (sum < 0) {
                sum=0;
            }
            max_sum = Integer.max(max_sum,sum);
        }
        System.out.println(max_sum);
    }

    public static void main(String[] args) {
        int arr[]={-2,-3,4,-1,-2,1,5,-3};
        kandanes_algo(arr);
    }
}
