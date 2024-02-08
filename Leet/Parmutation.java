import java.util.ArrayList;
import java.util.List;

public class Parmutation {
    List<List<Integer>> ans = new ArrayList<>();
    public void halper(ArrayList<Integer> nums, int idx){
        if (nums.size() == idx) {
            ans.add(new ArrayList<>(nums));
        }
        for (int i = idx; i < nums.size() ; i++) {
            int temp = nums.get(idx);
            nums.set(idx,nums.get(i));
            nums.set(i,temp);
            halper(nums,idx+1);
            temp = nums.get(idx);
            nums.set(idx,nums.get(i));
            nums.set(i,temp);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> n = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            n.add(nums[i]);
        }
        halper(n,0);
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        Parmutation p = new Parmutation();

        System.out.println(p.permute(arr));
    }
}
