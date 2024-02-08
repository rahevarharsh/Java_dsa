public class LastKeyindex {
    public static int lastkeyIndex(int arr[],int i,int key){
        if(i== arr.length){
            return  -1;
        }
        int nextIndex = lastkeyIndex(arr,i+1,key);
        if(arr[i]==key && nextIndex==-1){
            return i;
        }
        return nextIndex;
    }

    public static void main(String[] args) {
        int [] arr ={5,5,5,5,5};
        System.out.println(lastkeyIndex(arr,0,5));
    }
}
