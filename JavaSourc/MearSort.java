public class MearSort {
    public static void Meargsort(int arr[],int i,int j){
        if(i>=j){
            return;
        }
        int mid = i+ (j-i)/2;
        Meargsort(arr,i,mid);
        Meargsort(arr,mid+1,j);
        Marge(arr,i,mid,j);
    }
    public static void Marge(int arr[],int si,int mid,int ei){
        int[] temp = new int[ei-si+1];
        int k = 0;
        int i = si;
        int j = mid+1;
        while (i<=mid&&j<=ei){
            if (arr[i] <arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            temp[k++] = arr[i++];
        }
        while (j<=ei){
            temp[k++] = arr[j++];
        }
        for (int l = 0; l <temp.length ; l++) {
            arr[si++] = temp[l];
        }

    }

    public static void Quick(int arr[],int si,int ei){
        if(si>=ei){
            System.out.println("Quick sort");
            return;}
            int pivot = arr[ei];
            int pos = Partition(arr,pivot,si,ei);
            Quick(arr, si, pos-1);
            Quick(arr, pos+1, ei);

    }
    public static int Partition(int arr[],int p,int si,int ei){
        int i = si-1;
        for (int j = si; j <ei ; j++) {
            if (arr[j] < p) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[ei];
        arr[ei] = temp;
        return i;
    }
    public static void main(String[] args) {
        int arr[] = {7,2,4,8,1,3};
//        Meargsort(arr,0,arr.length-1);
        Quick(arr,0,arr.length-1);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
