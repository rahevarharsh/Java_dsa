import java.util.Arrays;
import java.util.Collection;

public class Prmutation {
    public static void parmutation(int arr[],int i){
        if (arr.length == i ) {
            System.out.print('[');
            for (int k = 0; k <arr.length ; k++) {
                System.out.print(" "+arr[k]);
            }
            System.out.println(']');
            return;
        }
        for (int k = i; k < arr.length ; k++) {
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            parmutation(arr, i+1);
             temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        parmutation(arr,0);
    }
}
