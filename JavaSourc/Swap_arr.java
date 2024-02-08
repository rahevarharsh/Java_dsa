public class Swap_arr {
    public static void arr_revars(int a[]){
        int l=0;
        int r = a.length-1;
        while (l<r){
            int temp = a[l];
            a[l] = a[r];
            a[r]=temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        arr_revars(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
