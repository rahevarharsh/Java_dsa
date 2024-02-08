public class Binary_search {
    public static int binary_search(int arr[],int target){
        int l = 0;
        int r = arr.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,79};
        System.out.println(binary_search(arr,6));
    }
}
