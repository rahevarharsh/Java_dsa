import java.util.Arrays;
import java.util.Comparator;

public class JumpGameII {

    public int jump(int[] nums) {
           int jump=0;
           int curr=0;
           int currMax = 0;
        for (int i = 0; i < nums.length-1 ; i++) {
            if (i+nums[i] > currMax) {
                currMax=i+nums[i];
            }
            if (i==curr) {
                curr = currMax;
                jump++;
            }

        }
        return jump;
    }

    public static void main(String[] args) {
        JumpGameII obj = new JumpGameII();
        int arr[]={2,3,1,2,4};

        System.out.println(obj.jump(arr));
//        System.out.println(obj.getIndex(arr,1));
    }
}
