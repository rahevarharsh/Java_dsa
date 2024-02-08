public class Selection_sort {
    public static void selection_sort(int arr[]){
        for (int i = 0; i <arr.length-1 ; i++) {
            int min = i;
            for (int j = i; j <arr.length ; j++) {
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min]=temp;
            for (int k = 0; k <arr.length ; k++) {
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int arr[]={5,4,10,3,2,1};
        selection_sort(arr);
    }
}
