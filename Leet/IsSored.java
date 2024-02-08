public class IsSored {
    public static boolean Issorted(int arr[],int i){
        if (arr.length == i+1) {
            return true;
        }
        if (arr[i]>arr[i+1]) {
            return false;
        }
        return Issorted(arr,i+1);
    }

    public static void main(String[] args) {
        int arr[]={12,1079,1082,1083};
        System.out.println(Issorted(arr,0));
    }
}
