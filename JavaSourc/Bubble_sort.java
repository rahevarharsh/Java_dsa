public class Bubble_sort {
    public static void bubble_sort(int arr[]){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length-i-1 ; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                }
                for (int k = 0; k <arr.length ; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.print(arr[i]+" ");
//        }
    }
    public static void main(String[] args) {
        int arr[] = {5,4,10,3,2,1};
        bubble_sort(arr);
    }
}
