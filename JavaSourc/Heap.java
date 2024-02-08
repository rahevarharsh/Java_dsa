public class Heap {
    static class Node{
        void heapify(int arr[],int idx,int end){
            int right = idx*2+2;
            int left = idx*2+1;
            int maxIdx = idx;
            if (left<=end && arr[ maxIdx]<arr[left] ) {
                maxIdx = left;
            }
            if (right<=end && arr[maxIdx]<arr[right]) {
                maxIdx = right;
            }
            if (maxIdx != idx) {
                int temp=arr[maxIdx];
                arr[maxIdx]=arr[idx];
                arr[idx]=temp;
                heapify(arr,maxIdx,end);
            }
        }
        void heapSort(int arr[]){
            int n = arr.length-1;
            for (int i = n/2; i >=0 ; i--) {
                heapify(arr,i,n);
            }

            System.out.println();
            for (int i = arr.length-1; i >0 ; i--) {

                int temp=arr[0];
                arr[0]=arr[i];
                arr[i] = temp;
                System.out.println("i :"+i);
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
                System.out.println();
                heapify(arr,0,i-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,3,5};
        Node m = new Node();
        m.heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
