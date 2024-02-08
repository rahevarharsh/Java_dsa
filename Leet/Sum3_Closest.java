import java.util.Arrays;

public class Sum3_Closest {
   public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
       int diff = Integer.MAX_VALUE;
       int Tsum  = 0;
       int p1 = 0;
       int p2 =1;
       int p3 = nums.length-1;
       for (int i = 0; i <= nums.length-2 ; i++) {
            p2 =i+1;
            p3 = nums.length-1;
           while(p2<p3){
               int sum = nums[i]+nums[p2]+nums[p3];
               System.out.println(nums[i]+"  "+nums[p2]+"  "+nums[p3]);
////          System.out.print(sum);
               if (diff > Math.abs(sum-target)) {
                   diff = Math.abs(sum-target);
                   Tsum = sum;
               }
//           max=Integer.max(Math.abs(sum-target),max);
               if (sum == target) {
                   return target;
               }
               if (sum < target && p3-p2==1) {
                   break;
               }
               else if (sum < target && p3-p2!=1) {
                   p2++;
               }
               else{
                   p3--;
               }

           }

       }
       return Tsum;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
//        for (int i = 0; i < nums.length ; i++) {
//            System.out.print(nums[i]+" ");
//        }
        System.out.println(threeSumClosest(nums,target));
    }
}
