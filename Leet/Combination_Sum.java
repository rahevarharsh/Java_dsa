import java.util.*;

public class Combination_Sum {
    List<List<Integer>> combo = new ArrayList<>();
    public  void halper(int arr[],int target,int currentSum,int idx,ArrayList<Integer> ls){
//        System.out.println("sum :"+currentSum+" "+ls);
         if(currentSum > target || arr.length==idx){
            return;
        }
         else  if (currentSum == target) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int d:ls){
                temp.add(d);
            }
            combo.add(temp);
//            System.out.println(combo);
            return;
        }
            ls.add(arr[idx]);
//            currentSum+=arr[i];
            halper(arr, target, currentSum+arr[idx], idx, ls);
            ls.remove(ls.size()-1);
            halper(arr,target,currentSum,idx+1,ls);
//            currentSum-=arr[i];

    }
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> ls = new ArrayList<>();
        halper(candidates,target,0,0,ls);
        ArrayList<ArrayList<Integer>> ra = new ArrayList<>();
        System.out.println(combo);
        return combo;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,5};
        Combination_Sum cs = new Combination_Sum();
        cs.combinationSum(arr,8);

    }
}
