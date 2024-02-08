public class NPpair {

    public void MakePair(int arr[]){

        for (int i = 0; i < arr.length-1 ; i++) {
            int curr = arr[i];
            int search = -1*curr;
            int seaIdx = 0;
            for (int j = i+1; j <arr.length ; j++) {
                if (search==arr[j]) {
                    seaIdx = j;
                    break;
                }
            }
            if (seaIdx == 0) {
                continue;
            }
            int temp = arr[++i];
            arr[i] = arr[seaIdx];
            arr[seaIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,4,5,3,-4,-3,-2};
        NPpair obj = new NPpair();
        obj.MakePair(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
