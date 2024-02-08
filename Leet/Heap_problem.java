public class Heap_problem {


    public static void Heapp(int arr[],int root){
        int left = root*2+1;
        int right = root*2+2;
        int maxval = root;
        if (left<arr.length&&arr[left]>arr[maxval]){
            maxval = left;
        }
        if (right<arr.length&&arr[right]>arr[maxval]) {
            maxval =right;
        }
        if (maxval != root) {
            System.out.println("IN");
            int temp = arr[root];
            arr[root] = arr[maxval];
            arr[maxval] = temp;
            Heapp(arr,maxval);
        }

    }
   public static void HeappyFy(int arr[]){
       for (int i = arr.length/2; i >=0 ; i--) {
            Heapp(arr,i);
       }
   }
    public static void main(String[] args) {
      int arr[]={2,1,4,5,3};
      HeappyFy(arr);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }


    }
}
//            5
//        3      4
//     1     2