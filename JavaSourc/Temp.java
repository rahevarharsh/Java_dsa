import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Temp {

    public static void main(String[] args) {
        int[][] arr = {{100, 2, 300, 4}, {20, 10, 50, 0}};

        Arrays.sort(arr,Comparator.comparingDouble(o->  o[2]));
        for (int i = 0; i < arr[0].length ; i++) {
            System.out.println(arr[1][i]);
        }
    }
}
