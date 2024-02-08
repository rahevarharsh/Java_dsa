import java.util.*;

public class FourSum {
    Set<ArrayList<Integer>> ans = new HashSet<>();
    public void halper(int nums[],int i,int sum,int numElement,ArrayList<Integer> temp,int target){

        if (numElement==4&&sum==target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (i == nums.length|| numElement>4) {
            return;
        }
        if (sum+nums[i] > target) {
            return;
        }

        temp.add(nums[i]);
        halper(nums, i+1, sum+nums[i], numElement+1, temp, target);
        temp.remove(temp.size()-1);
        halper(nums, i+1, sum, numElement, temp, target);

    }



    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        halper(nums,0,0,0,new ArrayList<>(),target);
        List<List<Integer>> re = new ArrayList<>();
        for (ArrayList<Integer> al : ans) {
            re.add(al);
        }
        return re;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
       int i1 = 0;
//       int i2 = 1;
//       int i3 = nums.length-2;
        Set<ArrayList<Integer>> retunans = new HashSet<>();
       int i4 = nums.length-1;
        while (i4-i1>=3){
            int i2 = i1+1;
            int i3 = i4-1;
            int sum = 0;
            while (i2<i3){
                sum = nums[i1]+nums[i2]+nums[i3]+nums[i4];
                System.out.println("["+nums[i1]+" "+nums[i2]+" "+nums[i3]+" "+nums[i4]+"]");
                if (sum==target) {
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(nums[i1]);
                    t.add(nums[i2]);
                    t.add(nums[i3]);
                    t.add(nums[i4]);
                    retunans.add(new ArrayList<>(t));
                    t = new ArrayList<>();
                    i2++;
                }
                else if (sum > target) {
                    i3--;
                }
                else{
                    i2++;
                }
            }
            if(sum>target){
                System.out.println("sum 1 :"+sum);
               i1++;
            }
            else{

                System.out.println("sum 2 :"+sum);
                i4--;
            }
        }

        List<List<Integer>> re = new ArrayList<>();
        for (ArrayList<Integer> al : retunans) {
            re.add(al);
        }

        return re;
    }

    public static void main(String[] args) {
        FourSum obj = new FourSum();
        int arr[]={-3,-1,0,2,4,5};
        int target = 2;
//        System.out.println(obj.fourSum(arr,target));
        System.out.println(obj.fourSum2(arr,target));

    }
}
