import java.util.ArrayList;
import java.util.List;

public class Subset {

    public void halper(int nums[],ArrayList<Integer> temp,List<List<Integer>> ans,int i){
        if (nums.length == i) {
            ans.add(new ArrayList<>(temp));
//            System.out.println(temp);
            return;
        }
        halper(nums, temp, ans, i+1);
        temp.add(nums[i]);
        halper(nums, temp, ans, i+1);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        halper(nums,new ArrayList<>(),ans,0);
        return ans;
    }

    public static void main(String[] args) {
    Subset s = new Subset();
    int arr[] = {0};

        System.out.println(s.subsets(arr));
    }
}
