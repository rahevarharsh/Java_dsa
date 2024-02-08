public class FindIndex {
    public static int Index(int arr[],int i,int key){
        if (arr.length == i) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return Index(arr,i+1,key);
    }
    public static void main(String[] args) {
        int arr[]={1,2,2,3,1,4,5,7,10,10,7,9};

        System.out.println(Index(arr,0,9));
    }
}
