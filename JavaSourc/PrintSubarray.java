public class PrintSubarray {

    public static void PrintSub_array(int arr[]){
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            int sum =0;
            for (int j = 0; j <=i ; j++) {
                sum +=arr[j];
            }
            max_sum=Integer.max(max_sum,sum);
            System.out.println();
        }
        System.out.println("MAX_SUM :"+max_sum);
    }

    public static void main(String[] args) {
        int arr[] = {1,-2,6,-1,-3};
        PrintSub_array(arr);
    }
}
