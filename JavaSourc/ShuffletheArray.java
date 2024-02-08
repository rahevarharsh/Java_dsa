public class ShuffletheArray {

    public int[] shuffle(int[] nums, int n) {
        int arr[] = new int[(2*n)];
        int idx=0;
        int i=0;
        while (idx<arr.length){
            arr[idx++] = nums[i];
            arr[idx++] = nums[n+i];
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {2,5,1,3,4,7};
        ShuffletheArray obj = new ShuffletheArray();
        obj.shuffle(arr,3);
    }
}
