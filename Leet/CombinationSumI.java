import java.util.*;

public class CombinationSumI {

//    List<List<Integer>> ans = new ArrayList<>();
     List<List<Integer>> ans= new ArrayList<>();
    public void halper(int arr[],int target,int idx,ArrayList<Integer> temp){
        if (idx==arr.length||target<0) {
            return;
        }
        if (target == 0) {
            ans.add(temp);
            return;
        }
        for (int i = idx; i <arr.length ; i++) {
            if (!temp.isEmpty()) {
                if (arr[i] == temp.get(temp.size()-1)) {
                    continue;
                }
            }
            if (arr[i] > target) {break;}
            temp.add(arr[i]);
            halper(arr, target-arr[i], idx, temp);
            temp.remove(temp.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        halper(candidates,target,0,new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
    int arr[]= {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
    CombinationSumI cs1 = new CombinationSumI();
        System.out.println (cs1.combinationSum2(arr,27));
    }
}
