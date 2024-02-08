import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
      int max =  Arrays.stream(nums).sum();

        return max/nums.length;
    }

    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        int arr[] = {3,0,1};
        ;
        System.out.println(obj.missingNumber(arr));
    }

}
