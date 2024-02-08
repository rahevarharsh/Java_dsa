public class Find_Number {
    public static int Min_arr(int arr[]){
        int min = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i] <min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int Max_arr(int arr[]){
        int max = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,-78,79};
        System.out.println(Min_arr(arr));
        System.out.println(Max_arr(arr));

    }
}
