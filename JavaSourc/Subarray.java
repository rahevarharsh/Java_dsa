public class Subarray {

    public static void Print_subarray(int arr[]){
        int sum_min =Integer.MAX_VALUE;
        int sum_max = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <=j ; k++) {
//                    System.out.print(arr[k]+" ");
                    sum +=arr[k];
                }
                sum_max=Integer.max(sum,sum_max);
                sum_min=Integer.min(sum,sum_min);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("max_sum :"+sum_max+"  min_sum :"+sum_min);
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        Print_subarray(arr);
    }
}
