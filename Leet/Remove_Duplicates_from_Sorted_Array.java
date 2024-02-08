import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        int a = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[a]!=arr[i]){
                arr[++a]=arr[i];
            }
        }
        for (int i = 0; i < a ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
