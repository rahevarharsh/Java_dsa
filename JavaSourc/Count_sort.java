public class Count_sort {
    public static void count_sort(int arr[]){
    int larg = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            larg = Integer.max(larg,arr[i]);
        }
        int[] count_arr = new int[larg+1];
        for (int i = 0; i <arr.length ; i++) {
            count_arr[arr[i]]++;
        }
        int count_p=0;
        int arr_p=0;
        while (arr_p!=arr.length){
            if(count_arr[count_p]==0){count_p++;}
            else{
                arr[arr_p] = count_p;
                count_arr[count_p]--;
                arr_p++;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[]={5,2,3,2,4,1,1,3,2};
    count_sort(arr);
    }
}
