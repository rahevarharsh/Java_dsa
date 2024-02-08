import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations_II {
    Map<List<Integer>,Integer> ans = new HashMap<>();
    public void halper(ArrayList<Integer> nums, int idx){
        if (nums.size() == idx) {
            ans.put(new ArrayList<>(nums),1);
        }
        for (int i = idx; i < nums.size() ; i++) {
            if (i != idx&&nums.get(i)==nums.get(i-1)) {
                continue;
            }
            int temp = nums.get(idx);
            nums.set(idx,nums.get(i));
            nums.set(i,temp);
            halper(nums,idx+1);
            temp = nums.get(idx);
            nums.set(idx,nums.get(i));
            nums.set(i,temp);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<Integer> n = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            n.add(nums[i]);
        }
        halper(n,0);
        List<List<Integer>> l = new ArrayList<>();
        for (List<Integer> name : ans.keySet()){
            l.add(name);
        }
        return l;
    }

    public static void main(String[] args) {
        int arr[]={1,1,2};
        Permutations_II p = new Permutations_II();
        System.out.println(p.permuteUnique(arr));
    }
}
