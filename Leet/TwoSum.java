import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length ; i++) {
            if (map.containsKey(target-nums[i])&&map.get(target-nums[i])!=i) {
                int re[] = {i,map.get(target-nums[i])};
                return re;
            }
        }
        
        return new int[0];
    }

    public static void main(String[] args) {
        int arr[] = {3,3};
        TwoSum obj = new TwoSum();
        obj.twoSum(arr,6);
    }
}
