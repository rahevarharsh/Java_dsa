public class SubArraySumII {
    public static void subArray_II(int arr[]){
        int[] sum_arr = new int[arr.length];
//        prefix sum_ARRAY
        for (int i = 0; i <arr.length ; i++) {
            if(i==0){sum_arr[0] = arr[0];}
            else{sum_arr[i] =sum_arr[i-1]+arr[i];}
        }
        int max_sum =Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            int sum =0;
            for (int j = i; j <arr.length ; j++) {
                sum = (i==0)?sum_arr[j]:sum_arr[j]-sum_arr[i-1];
            }
            max_sum =Integer.max(max_sum,sum);
        }
        System.out.println(max_sum);
    }

    public static void main(String[] args) {
    int arr[]= {1,-2,6,-1,3};
    subArray_II(arr);
    }
}
