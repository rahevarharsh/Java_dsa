public class Insertion_sort {
    public static void insertion_sort(int arr[]){
        for (int i = 1; i <arr.length ; i++) {
            int j = i-1;
            int temp = arr[i];
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;

        }
        for (int k = 0; k <arr.length ; k++) {
            System.out.print(arr[k]+" ");
        }
        
    }

    public static void main(String[] args) {
        int arr[]={5,4,3,2,1};
        insertion_sort(arr);
    }
}
